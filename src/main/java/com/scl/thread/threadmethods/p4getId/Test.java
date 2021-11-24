package com.scl.thread.threadmethods.p4getId;

/**
 * @description: 每一个线程都有一个id,通过getId方法获取id
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:39
 */
public class Test {
    public static void main(String[] args){
        System.out.println("当前线程的id是"+Thread.currentThread().getId());
        Mythread t = new Mythread();
        t.start();
    }
}    