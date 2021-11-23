package com.scl.thread.wait;

/**
 * @description: notify 和  notifyAll 的区别
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 14:03
 */
public class Test06 {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        SubThread t1 = new SubThread(lock);
        SubThread t2 = new SubThread(lock);
        SubThread t3 = new SubThread(lock);
        SubThread t4 = new SubThread(lock);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        Thread.sleep(1000);

        synchronized (lock){
            //lock.notify();  多个线程情况下，notify随机通知一个线程  notifyAll 通知所有的线程
            lock.notifyAll();
        }

    }

    static class SubThread extends  Thread{

        private Object lock;

        public SubThread(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread().getName()+" start wait");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName()+" end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}    