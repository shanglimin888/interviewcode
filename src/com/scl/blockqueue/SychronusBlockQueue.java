package com.scl.blockqueue;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description: SychronusBlockQueue的使用
 * @author: shanglimin888@163.com
 * @time: 2021/9/29 14:16
 */
public class SychronusBlockQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                queue.put(Thread.currentThread().getName()+"1");
                queue.put(Thread.currentThread().getName()+"2");
                queue.put(Thread.currentThread().getName()+"3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }
}    