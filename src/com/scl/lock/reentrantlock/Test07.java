package com.scl.lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: tryLock(long timeout, TimeUnit unit)的基本使用
 * @author: shanglimin888@163.com
 * @time: 2021/6/22 21:11
 */
public class Test07 {

    static class SubRunnable implements Runnable{

        static ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)){//如果当前线程3秒钟中没有获得到lock,执行else代码
                    System.out.println(Thread.currentThread().getName()+"获取到锁");
                    Thread.sleep(10000);//模拟线程业务时间为4秒
                }else{
                    System.out.println(Thread.currentThread().getName()+"没有获取到锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        }
    }

    public static void main(String[] args){
       SubRunnable r = new SubRunnable();

       new Thread(r).start();
       new Thread(r).start();
    }

}    