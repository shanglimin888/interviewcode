package com.scl.wait;

/**
 * @description: notify通知过早 导致程序执行顺序混乱
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 14:28
 */
public class Test08 {
    public static void main(String[] args){
         Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock){
                        System.out.println("start wait");
                        lock.wait();
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("start notify");
                    lock.notify();
                    System.out.println("end notify");
                }
            }
        });

      /*  t1.start();
        t2.start();*/

       t2.start();
       t1.start();


    }
}    