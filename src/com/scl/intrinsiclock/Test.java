package com.scl.intrinsiclock;

/**
 * @description: 同步代码块 锁对象
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test {
    public static void main(String[] args){


        Test test = new Test();  //sychronized 锁住的是该对象
        new Thread(()->{

            test.mm();
        },"t1").start();

        new Thread(()->{
            test.mm();
        },"t2").start();

    }



    public void mm(){
        synchronized (this) {  //同步代码块，一般写法，锁住当前对象
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }

}    