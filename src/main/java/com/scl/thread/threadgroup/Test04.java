package main.java.com.scl.thread.threadgroup;

/**
 * @description: 线程组的批量中断 中断线程组会中断线程组中所有的线程
 * @author: shanglimin888@163.com
 * @time: 2021/7/13 14:41
 */
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName()+"--正在执行");
                    /*try {
                        Thread.sleep(100);// 打断睡眠中的线程，异常之后会更新中断标志
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
                System.out.println(Thread.currentThread().getName()+"循环结束");
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(group,r,"t"+i).start();
        }

        Thread.sleep(100);

        group.interrupt();


    }
}    