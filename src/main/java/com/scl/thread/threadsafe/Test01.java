package com.scl.thread.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 演示线程的原子性
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 15:59
 */
public class Test01 {
    public static void main(String[] args){
        //启动两个线程，不停的调用getNum方法
        Mynum mynum = new Mynum();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+" " + mynum.getNum());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

    }

    static class Mynum{
        //int num;
        AtomicInteger num = new AtomicInteger();
        public  int getNum(){
            return  num.getAndIncrement();
        }
    }
}    