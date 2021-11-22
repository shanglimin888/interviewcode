package com.scl.threadmethods.p2isAlive;

/**
 * @description: 线程的普通方法：t.isAlive（）判断线程是否处于活动状态
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:22
 */
public class Test {
    public static void main(String[] args){
        Mythread r = new Mythread();
        Thread t = new Thread(r);
        System.out.println("是否存活"+t.isAlive());
        t.start();
        System.out.println("是否存活"+t.isAlive());

    }


}    