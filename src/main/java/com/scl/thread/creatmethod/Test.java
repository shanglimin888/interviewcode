package main.java.com.scl.thread.creatmethod;

import main.java.com.scl.thread.creatmethod.runnable.MyThread02;
import main.java.com.scl.thread.creatmethod.thread.MyThread01;

/**
 * @description: 新建线程的三种方式
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:08
 */
public class Test {
    public static void main(String[] args){
        //新建线程的第一种方式，继承Thread类，重写run方法
        MyThread01 t1 = new MyThread01();
        t1.start();


        //新建线程的第二种方式，实现runnable接口，重写run方法
        MyThread02 t2 = new MyThread02();
        new Thread(t2).start();

        //还有一种写法是用匿名内部类的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新建线程的第三种方式");
            }
        }).start();
    }
}    