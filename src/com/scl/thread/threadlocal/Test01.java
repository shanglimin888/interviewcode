package com.scl.thread.threadlocal;

/**
 * @description: ThreadLocal的基本使用  ThreadLocal主要为每个线程绑定自己的值
 * 例子：一群学生要写字，只有一支笔，  老师看着这支笔，一个学生用完另一个学生用
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 13:52
 */
public class Test01 {

    static ThreadLocal threadLocal = new ThreadLocal();

    static class SubThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                //设置线程关联的值
                threadLocal.set(Thread.currentThread().getName()+" "+ i);

                //读取线程关联的值
                System.out.println(Thread.currentThread().getName() + "读出" + threadLocal.get());
            }
        }
    }

    public static void main(String[] args){

        SubThread t1 = new SubThread();
        SubThread t2 = new SubThread();

        t1.start();
        t2.start();

    }
}    