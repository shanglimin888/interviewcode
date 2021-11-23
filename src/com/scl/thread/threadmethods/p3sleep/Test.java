package com.scl.thread.threadmethods.p3sleep;

/**
 * @description: 线程的静态方法 sleep 休眠
 * 定时60秒
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:31
 */
public class Test {
    public static void main(String[] args){
        int count = 5;
        while (count>0){
            System.out.println("剩余"+count+"秒");
            count--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("60秒时间到了");
    }
}    