package com.scl.thread.threadmethods.p6interrupt;

/**
 * @description: 线程的方法 interrupt 和 isInterrupt  可以打断线程的执行
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 15:00
 */
public class Test {
    public static void main(String[] args){
        Mythread t = new Mythread();
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main"+i);
        }
        t.interrupt();

    }
}    