package com.scl.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: lockinterruptibly 当前线程不被中断获得锁，被中断会抛异常
 * @author: shanglimin888@163.com
 * @time: 2021/6/22 15:45
 */
public class Test05 {

    static class service{
        private Lock lock = new ReentrantLock();

        private void method(){
            try {
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+" 上锁");
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    new StringBuilder();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+" 释放锁");
                lock.unlock();
            }
        }


     public static void main(String[] args) throws InterruptedException {
         service s = new service();
         Runnable r = new Runnable() {
             @Override
             public void run() {
                 s.method();
             }
         };

         Thread t1 = new Thread(r);
         t1.start();

         Thread.sleep(1000);
         Thread t2 = new Thread(r);
         t2.start();
         t2.interrupt();
         Thread.sleep(500);
     }

    }


}    