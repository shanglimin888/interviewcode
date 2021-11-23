package com.scl.thread.threadgroup;

/**
 * @description: 演示复制线程组中的内容
 * @author: shanglimin888@163.com
 * @time: 2021/7/13 14:04
 */
public class Test03 {
    public static void main(String[] args){
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();//main线程组
        ThreadGroup group1 = new ThreadGroup(mainGroup, "group1");//main线程组的子线程组group1
        ThreadGroup group2 = new ThreadGroup("group2");//线程组group2  默认父线程组也是main线程组

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(mainGroup, r, "t1");//main线程组下的线程t1
        Thread t2 = new Thread(group2,r, "t2");//group线程组下的线程t2
        Thread t3 = new Thread(group1,r,"t3");//t3,默认属于main线程组下

        t1.start();
        t2.start();
        t3.start();

        Thread [] tList = new Thread[mainGroup.activeCount()];

        /*mainGroup.enumerate(tList);//将main线程组下所有的线程复制到tList中 包含子线程组下的所有线程
        for(Thread item:tList) {
            System.out.println(item);
        }*/

        mainGroup.enumerate(tList,true);
        for(Thread item:tList) { //将main线程组下的所有线程复制到tList中，不包含子线程组下的线程
            System.out.println(item);
        }

        System.out.println(mainGroup.activeCount());

    }
}    