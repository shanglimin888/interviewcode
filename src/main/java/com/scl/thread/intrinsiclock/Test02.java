package main.java.com.scl.thread.intrinsiclock;

/**
 * @description: 同步代码块 锁对象
 * 如果不是一个对象是无法实现同步数据的，同步的数据是本对象
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test02 {
    public static void main(String[] args){

        Test02 test = new Test02();
        Test02 test02 = new Test02();
        new Thread(()->{

            test.mm();
        },"t1").start();

        new Thread(()->{
            test02.mm();
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