package com.scl.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: wait条件发生变化
 * 1）定义一个集合list
 * 2) 定义线程往集合中放数据，并通知其他线程从集合中取数据
 * 3）定义线程当集合不是0时从集合中取数据，且将数据移除
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 14:59
 */
public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        addThread t1 = new addThread();
        t1.setName("addthread");
        getThread t2 = new getThread();
        t2.setName("getthread1");
        getThread t3 = new getThread();
        t3.setName("getthread2");

        //测试一：一个线程放数据，一个线程取数据  先放入数据再取出数据
        //测试二：一个线程放数据，一个线程取数据  先放入数据再取出数据
        //测试三：一个线程放数据，两个线程取数据  先放入再取数据

        t2.start();
        t3.start();
        Thread.sleep(1000);
        t1.start();

    }

    //1)定义一个集合
    private static List list = new ArrayList();
    //2)定义一个从集合中取数据的方法
    public synchronized static void getData(){
        //synchronized (list){
           /* if(list.size() == 0){
                try {
                    System.out.println(Thread.currentThread().getName() + "start wait");
                    Test10.class.wait();
                    System.out.println(Thread.currentThread().getName() + "end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        while(list.size() == 0){
            try {
                System.out.println(Thread.currentThread().getName() + " start wait");
                Test10.class.wait();
                System.out.println(Thread.currentThread().getName() + " end wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println(Thread.currentThread().getName()+"从集合中取出"+list.get(0));
            list.remove(0);
        //}
    }
    //3)定义向集合中添加数据
      public synchronized static void addData(){
       // synchronized (list){
            list.add("hello world");
            Test10.class.notifyAll();
            System.out.println(Thread.currentThread().getName() + " 先集合中放入数据");
        //}
    }
    //4)定义线程类  从集合中取数据 调用getData方法
    static class getThread extends Thread{
        @Override
        public void run() {
            getData();
        }
    }
    //5)定义线程类 向集合中放入数据 调用addData方法
    static class addThread extends Thread{
        @Override
        public void run() {
            addData();
        }
    }


}    