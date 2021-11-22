package com.scl.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 当锁对象没有被别的线程持有 才获得锁定
 * @author: shanglimin888@163.com
 * @time: 2021/6/23 9:14
 */
public class Test08 {

    static class service{
         private ReentrantLock lock = new ReentrantLock();

        private void methodA(){

            try {
                if(lock.tryLock()){
                    System.out.println(Thread.currentThread().getName()+" 获得lock");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+" 锁定结束");
                }else{
                    System.out.println(Thread.currentThread().getName()+" 未获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        service service = new service();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                service.methodA();
            }
        };

        Thread t1 = new Thread(r);
        t1.setName("t1");
        t1.start();

        //Thread.sleep(50);

        Thread t2 = new Thread(r);
        t1.setName("t2");
        t2.start();

    }

}    