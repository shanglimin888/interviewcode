package com.scl.thread.threadmethods.p7setDemon;

/**
 * @description: 线程分为两种，一种是用户线程，一种是守护线程，守护线程不能单独运行  setDaemon设置为守护线程
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 15:06
 */
public class Test {
    public static void main(String[] args){
        Mythread t = new Mythread();
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main"+i);
        }
    }
}    