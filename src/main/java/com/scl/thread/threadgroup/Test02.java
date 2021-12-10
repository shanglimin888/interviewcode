package main.java.com.scl.thread.threadgroup;

import com.sun.org.glassfish.gmbal.Description;

/**
 * @description: 演示线程组的基本操作
 * @author: shanglimin888@163.com
 * @time: 2021/7/13 10:33
 */
public class Test02 {
    public static void main(String[] args){
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();//返回当前线程组
        //再定义线程组
        ThreadGroup group = new ThreadGroup("group"); //默认group的父线程组是mainGroup

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("当前线程"+Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(r,"t1");//默认再main线程组中新建线程t1
        Thread t2 = new Thread(group, r, "t2"); //在group线程组中新建线程t2
        t1.start();
        t2.start();

        //*********************************************
        //打印线程组相关信息
        System.out.println("main线程组中活动线程数量"+mainGroup.activeCount());//四个 分别是 main t1,t2,垃圾回收器

        System.out.println("group线程组中活动线程数量"+group.activeCount());

        System.out.println("group线程组中子线程组的数量"+group.activeGroupCount());//数量为0

        System.out.println("main线程组中父线程组的数量"+mainGroup.activeGroupCount());//数量为1  system

        System.out.println("group线程组的父线程组是谁"+group.getParent());

        System.out.println(mainGroup.parentOf(mainGroup)); //main线程是自己线程的父线程组
        System.out.println(mainGroup.parentOf(group));//main线程组是group的父线程组

        mainGroup.list();//main线程下所有的线程组和线程

    }
}    