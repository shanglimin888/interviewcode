package com.scl.lock.method;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:  公平锁与非公平锁
 * @author: shanglimin888@163.com
 * @time: 2021/7/6 21:43
 */
public class Test01 {
    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName()+"--获得了锁");
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(r).start();
        }

    }
}    