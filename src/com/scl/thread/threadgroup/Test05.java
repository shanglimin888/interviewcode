package com.scl.thread.threadgroup;

/**
 * @description: 演示守护线程组
 * @author: shanglimin888@163.com
 * @time: 2021/7/13 15:10
 */
public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group");
        group.setDaemon(true);//将group设置为守护线程组

        for (int i = 0; i < 3; i++) {
            new Thread(group, new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20; j++) {
                        System.out.println(Thread.currentThread().getName()+"--"+j);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        Thread.sleep(5000);

        System.out.println("thread main is over...");

    }
}    