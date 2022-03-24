package main.java.com.scl.thread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: reentrantlock的基本使用
 * @author: shanglimin888@163.com
 * @time: 2021/6/22 13:57
 */
public class Test02 {

    static ReentrantLock lock = new ReentrantLock();

    static class SubRunnable implements Runnable{
        @Override
        public void run() {
           sm();
           System.out.println(Thread.currentThread().getName()+"over");
        }

        private static void sm() {
            lock.lock();
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName()+"----"+i);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args){

        SubRunnable r = new SubRunnable();

        for (int i = 0; i < 30; i++) {
            new Thread(r).start();
        }
    }
}    