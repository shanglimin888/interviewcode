package com.scl.thread.intrinsiclock;

/**
 * @description: 同步代码块同步方法如何选择呢
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test07 {
    public static void main(String[] args){


        Test07 test = new Test07();
        new Thread(()->{

            test.mm();
        },"t1").start();

        new Thread(()->{
            test.mm();       //this 对象就是 test
        },"t2").start();

    }


    public void mm(){
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }

}    