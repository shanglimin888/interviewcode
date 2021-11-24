package com.scl.thread.wait;

/**
 * @description: interrupt 会中断wait()方法，会抛异常 interruptException
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 9:52
 */
public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        SubThread t1 = new SubThread();

        t1.start();

        Thread.sleep(1000);

        t1.interrupt();

    }


    static class  SubThread extends Thread{

        private static final Object Lock = new Object();

        @Override
        public void run() {
            synchronized (Lock){
                try {
                    System.out.println("begin wait");
                    Lock.wait();
                    System.out.println("end wait");
                } catch (InterruptedException e) {
                    System.out.println("线程被打断");
                }
            }
        }
    }
}    