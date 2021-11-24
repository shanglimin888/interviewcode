package com.scl.thread.lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 同一把锁 同步不同的方法
 * @author: shanglimin888@163.com
 * @time: 2021/6/22 14:08
 */
public class Test03 {

    static Lock lock = new ReentrantLock();

    public static void m1(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"- - m1 begin"+System.currentTimeMillis());
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName()+"- - m1 end"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void m2(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"- - m2 begin"+System.currentTimeMillis());
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName()+"- - m2 end"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                m1();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                m2();
            }
        };

        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();

        new Thread(r2).start();
        new Thread(r2).start();
        new Thread(r2).start();

    }


}    