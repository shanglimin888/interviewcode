package com.scl.thread.intrinsiclock;

/**
 * @description: 同步代码块 锁对象
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test05 {
    public static void main(String[] args){


        Test05 test = new Test05();
        new Thread(()->{

            test.mm();         //两个对象，不是同一把锁
        },"t1").start();

        new Thread(()->{
            test.sm();       //this 对象就是 test
        },"t2").start();


    }



    public void mm(){
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }

    public synchronized   void sm(){   //修饰方法 默认是this 本对象
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
    }




}    