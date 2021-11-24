package com.scl.thread.wait;

/**
 * @description: 通过notify()唤醒等待的线程
 * 创建两个线程  t1 t2  共同的来竞争一个锁对象 是一个字符串对象   t1线程等待   t2来唤醒t1
 * @author: shanglimin888@163.com
 * @time: 2021/6/14 22:17
 */
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        String text = "shanglimin";
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1的run方法");
                synchronized (text) {
                    try {
                        System.out.println("t1在等待前");
                        text.wait();   //线程状态进入 blocked
                        System.out.println("t1在等待后");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.setName("t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2的run方法");
                synchronized (text) {
                    System.out.println("t2唤醒前");
                    text.notify(); //唤醒其中一个线程
                    System.out.println("t2唤醒后");
                }
            }
        });
        t2.setName("t2");


        t1.start();

        Thread.sleep(1000);

        t2.start();

    }
}    