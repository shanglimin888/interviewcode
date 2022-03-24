package main.java.com.scl.thread.threadsafe;

import java.util.Random;

/**
 * @description: 测试线程可见性
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 16:22
 */
public class Test02 {
    public static void main(String[] args) throws Exception{
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();

        Thread.sleep(1000);
        myTask.cancel();
    }

    static class MyTask implements Runnable{
        private boolean toCancel = false;
        @Override
        public void run() {
            while (!toCancel){
                if(doSomething()){
                }
            }

            if(toCancel){
                System.out.println("任务被取消");
            }

        }

        private boolean doSomething() {
            System.out.println("执行某个任务");
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  true;
        }

        private void cancel(){
            System.out.println("主线程说了，让停止任务");
            this.toCancel=true;

        }
    }


}    