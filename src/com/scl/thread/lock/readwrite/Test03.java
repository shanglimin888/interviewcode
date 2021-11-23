package com.scl.thread.lock.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 读写锁之写写互斥
 * @author: shanglimin888@163.com
 * @time: 2021/7/11 17:31
 */
public class Test03 {

    static class Service{
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock writeLock = lock.writeLock(); //获得写锁
        public  void writeMethod(){
            try {
                writeLock.lock();
                System.out.println(Thread.currentThread().getName()+" 执行写锁上锁完毕"+System.currentTimeMillis());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+" 执行写锁解锁完毕"+System.currentTimeMillis());
                writeLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                service.writeMethod();
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(r).start();
        }

        Thread.sleep(5000);

    }





}    