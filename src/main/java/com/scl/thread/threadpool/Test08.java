package main.java.com.scl.thread.threadpool;

import java.util.concurrent.*;

/**
 * @description: 自定义线程池，对ThreadPoolExecutor 进行包装
 * @author: shanglimin888@163.com
 * @time: 2021/7/27 15:34
 */
public class Test08 {

    public static class TrackThreadPoolExecutor extends ThreadPoolExecutor{

        public TrackThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        //定义方法，两个入参，第一个参数接受要执行的任务，第二个参数是一个Exception异常
        public Runnable wrap(Runnable task, Exception exception){
            return new Runnable() {
                @Override
                public void run() {
                    try {
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            };
        }

        //重写submit方法
        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(wrap(task,new RuntimeException("客户跟踪异常")));
        }

        //重写execute方法
        @Override
        public void execute(Runnable command) {
            super.execute(wrap(command,new RuntimeException("客户跟踪异常")));
        }

        public static class DivideTask implements Runnable{
            private int x;
            private int y;

            public DivideTask(int x,int y){
                this.x=x;
                this.y=y;
            }

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"计算"+x+"/"+y+"="+(x/y));
            }
        }
    }

    public static void main(String[] args){
        //使用自定义线程池
        TrackThreadPoolExecutor trackThreadPoolExecutor = new TrackThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new SynchronousQueue<>());
        //向线程池添加两个数相除的任务
        for (int i = 0; i < 5; i++) {
            //trackThreadPoolExecutor.submit(new TrackThreadPoolExecutor.DivideTask(10,i));
            trackThreadPoolExecutor.execute(new TrackThreadPoolExecutor.DivideTask(10,i));
        }
    }
}    