package com.scl.thread.lock.reentrantlock;

/**
 * @description: 演示锁的可重入性，当一个线程持有资源对象的锁时，代码执行中继续持有锁
 * @author: shanglimin888@163.com
 * @time: 2021/6/22 10:32
 */
public class Test01 {

    public static synchronized void method01(){
        System.out.println(Thread.currentThread().getName()+"同步方法1");

        method02();
    }

    public static synchronized void method02() {
        System.out.println(Thread.currentThread().getName()+"同步方法2");

        method03();
    }

    public static synchronized void method03() {
        System.out.println(Thread.currentThread().getName()+"同步方法3");
    }

    public static void main(String[] args){

        for (int i = 0; i < 5; i++) {
            new Thread(){
                @Override
                public void run() {
                    method01();
                }
            }.start();
        }

    }
}    