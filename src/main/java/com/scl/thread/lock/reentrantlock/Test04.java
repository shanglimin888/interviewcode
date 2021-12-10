package main.java.com.scl.thread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: reentrantlock的可重入性,一个线程多次获得锁
 * @author: shanglimin888@163.com
 * @time: 2021/6/22 15:28
 */
public class Test04 {

    public static ReentrantLock lock = new ReentrantLock();

    public static int num=0;
    static class SubThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                try {
                    lock.lock();
                    lock.lock();
                    num++;
                } finally {
                    lock.unlock();
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubThread t1 = new SubThread();
        SubThread t2 = new SubThread();
        SubThread t3 = new SubThread();
        SubThread t4 = new SubThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

       /* t1.join();
        t1.join();
        t1.join();
        t1.join();*/

       Thread.sleep(62);

        System.out.println(Test04.num);
    }


}