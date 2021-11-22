package com.scl.lock.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 读写锁之读写互斥
 * @author: shanglimin888@163.com
 * @time: 2021/7/11 17:31
 */
public class Test02 {

    static class Service{
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock readLock = lock.readLock(); //获得读锁
        Lock writeLock = lock.writeLock(); //获得写锁
        public  void readMethod(){
            try {
                readLock.lock();
                System.out.println(Thread.currentThread().getName()+" 执行读锁上锁完毕"+System.currentTimeMillis());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+" 执行读锁解锁完毕"+System.currentTimeMillis());
                readLock.unlock();
            }
        }

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

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                service.writeMethod();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                service.readMethod();
            }
        };

            new Thread(r1).start();


            new Thread(r2).start();



        Thread.sleep(5000);

    }





}    