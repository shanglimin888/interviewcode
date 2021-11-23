package com.scl.thread.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 多个condition 分别通知，分别等待 比 sychronized更加灵活
 * @author: shanglimin888@163.com
 * @time: 2021/7/6 20:44
 */
public class Test02 {
    static class service{
        private ReentrantLock lock = new ReentrantLock(); //定义锁对象 //定义两个 Condtion 对象
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();


        public void waitMethodA(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"methodA wait"+System.currentTimeMillis());
                conditionA.await();
                System.out.println(Thread.currentThread().getName()+"methodA end wait"+System.currentTimeMillis());
            } catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
        }

        public void waitMethodB(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"methodB wait"+System.currentTimeMillis());
                conditionB.await();
                System.out.println(Thread.currentThread().getName()+"methodB end wait"+System.currentTimeMillis());
            }  catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
        }

        public void signalA(){
            try {
                lock.lock();
                conditionA.signal();
                System.out.println(Thread.currentThread().getName()+"conditionA signal"+System.currentTimeMillis());
            } finally {
                lock.unlock();
            }
        }

        public void signalB(){
            try {
                lock.lock();
                conditionB.signal();
                System.out.println(Thread.currentThread().getName()+"conditionB signal"+System.currentTimeMillis());
            } finally {
                lock.unlock();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        service ser = new service();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ser.waitMethodA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ser.waitMethodB();
            }
        }).start();

        Thread.sleep(3000);


        ser.signalA();
        ser.signalB();

    }


}    