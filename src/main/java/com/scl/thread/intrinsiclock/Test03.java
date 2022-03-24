package main.java.com.scl.thread.intrinsiclock;

/**
 * @description:
 * 同步代码块，除了用sychronized(this) 还可以用sychronized(常量)这种用法
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test03 {
    public static void main(String[] args){


        Test03 test = new Test03();
        Test03 test02 = new Test03();
        new Thread(()->{

            test.mm();
        },"t1").start();

        new Thread(()->{
            test02.mm();
        },"t2").start();

    }

    //常量
    public static final String OBJ = "hello";

    public void mm(){
        synchronized (OBJ) {//除了同步本对象，还可以同步一个常量
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }




}    