package com.scl.thread.juc.waitnotity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三种wait notify的演示
 * synchronized
 * conditon
 * 上面两种局限性:
 * 1.必须在锁块中使用 不然会报IllegalMonitorStateException
 * 2.只能先等待再通知，不然等待的线程陷入无限等待
 *
 * locksupport
 *
 *
 */
public class ThreeWaitNotifyDemo {
   static String A = "AAA";

    public static void main(String[] args) {
//        synchronizedBlock(A);
//        conditionBlock();
        Thread threadA = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\tis coming!");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"\tis coming!");
        }, "AAA");
        threadA.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\tis coming!");
            LockSupport.unpark(threadA);
            System.out.println(Thread.currentThread().getName()+"\tis coming!");
        }, "BBB").start();



    }

    private static void conditionBlock() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"\tis coming!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\tis gone!");
            }finally {
                lock.unlock();
            }
        },"AAA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"\tis coming!");
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"\tis gone!");
            }finally {
                lock.unlock();
            }
        },"BBB").start();
    }

    private static void synchronizedBlock(String a) {
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"\tis coming!");
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\tis gone!");
            }
        },"AAA").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (A){
                System.out.println(Thread.currentThread().getName()+"\tis coming!");
                    a.notify();
            }
        },"BBB").start();
    }


}
