package com.scl.intrinsiclock;

/**
 * @description: 同步代码块 锁对象 使用常量作为锁对象
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test04 {
    public static void main(String[] args){


        Test04 test = new Test04();
        Test04 test02 = new Test04();
        //Test04 test03 = new Test04();
        new Thread(()->{

            test.mm();         //
        },"t1").start();

        new Thread(()->{
            test02.mm();       //
        },"t2").start();

       /* new Thread(()->{
            test03.sm();       //
        },"t3").start();*/


    }

    //使用一个常量作为锁对象
    public static final String OBJ = "hello";

    //使用字符串可以不用常量，因为在常量池，只有一份  大概是这么个意思，我没有深究
    //public static final String OBJ = "hello";

    //可以
    //public static final Object OBJ = new Object();

    //不可以
    //public  Object OBJ = new Object();



    public void mm(){
        synchronized (OBJ) {
            //for循环打印0-99
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }

    //若是静态方法，不同的实例对象调用，也可以同步
    /*public static  void sm(){
        synchronized (OBJ) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }*/




}    