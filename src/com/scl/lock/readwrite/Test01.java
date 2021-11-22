package com.scl.lock.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 读写锁之读读共享
 * @author: shanglimin888@163.com
 * @time: 2021/7/11 17:23
 */
public class Test01 {
    static class Service{
        ReadWriteLock lock = new ReentrantReadWriteLock();

        public void readMethod(){
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"获取到了读锁---"+System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+"释放读锁---"+System.currentTimeMillis());
                lock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args){
        Service service = new Service();
        for (int i = 0; i <5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                        service.readMethod();
                }
            }).start();
        }
    }

}    