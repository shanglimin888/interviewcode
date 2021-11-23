package com.scl.thread.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: condition 等待与通知
 * @author: shanglimin888@163.com
 * @time: 2021/7/6 9:38
 */
public class Test01 {
    //先声明锁
    static  Lock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

   static  public class Subthread extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("lock method");
                condition.await();
                System.out.println("lock await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("lock unlock");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Subthread t = new Subthread();
        t.start();

        Thread.sleep(3000);
        try {
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
            System.out.println("unlock2");
        }
    }


}    