package com.scl.wait;

import java.util.ArrayList;

/**
 * @description: notify 不会立即释放锁
 * @author: shanglimin888@163.com
 * @time: 2021/6/14 22:33
 */
public class Test04 {
public static void main(String[] args) throws InterruptedException {
    ArrayList<String> strList = new ArrayList<String>();

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {

            synchronized (strList) {
                if (strList.size() != 5) {
                    try {
                        System.out.println("线程1等待");
                        strList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });


    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (strList) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程2添加第"+(i+1)+"个数据");
                    strList.add("data" + i);
                    if (strList.size()==5){
                        strList.notify();
                        System.out.println("线程2发现唤醒通知");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });

    t1.start();

    Thread.sleep(1000);

    t2.start();



}
}    