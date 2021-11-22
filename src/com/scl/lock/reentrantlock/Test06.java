package com.scl.lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用lock.lockinterruptbily 解决死锁问题
 * @author: shanglimin888@163.com
 * @time: 2021/6/22 20:27
 */
public class Test06 {

    static class SubRunnable implements Runnable {

        //准备两个锁 静态
        public static ReentrantLock lock1 = new ReentrantLock();
        public static ReentrantLock lock2 = new ReentrantLock();

        private int num;

        //构造方法初始化num
        public SubRunnable(int num) {
            this.num = num;
        }

        @Override
        public void run() {

            try {
                //让同一个线程顺序去持有两把锁  lock1 lock2
                if (num % 2 == 1) {  //奇数 先lock1 再lock2
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "先获取锁1");

                    Thread.sleep(new Random().nextInt(500));
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "再获取锁2");


                } else {
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "先获取锁2");

                    Thread.sleep(new Random().nextInt(500));
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "再获取锁1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock2.isHeldByCurrentThread())
                    lock2.unlock();
                if (lock1.isHeldByCurrentThread())
                    lock1.unlock();
            }


        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubRunnable r1 = new SubRunnable(11);
        SubRunnable r2 = new SubRunnable(22);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        Thread.sleep(3000);

        if (t2.isAlive())
            t2.interrupt();


    }


}    