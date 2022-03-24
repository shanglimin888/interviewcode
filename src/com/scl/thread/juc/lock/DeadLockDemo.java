package com.scl.thread.juc.lock;

import java.util.concurrent.TimeUnit;

class ShareSource{
    private String strA;
    private String strB;

    public ShareSource(String strA,String strB){
        this.strA = strA;
        this.strB = strB;
    }


    public void methodA(){
        synchronized (strA){
            try {
                TimeUnit.SECONDS.sleep(2l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"已经持有"+strA+"的锁，尝试获得"+strB+"的锁");
            synchronized (strB){
            }
        }
    }


    public void methodB(){
        synchronized (strB){
            try {
                TimeUnit.SECONDS.sleep(2l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"已经持有"+strB+"的锁，尝试获得"+strA+"的锁");
            synchronized (strA){
            }
        }
    }




}

/**
 * 实现一个死锁
 */
public class DeadLockDemo {
    public static void main(String[] args){
        ShareSource shareSource = new ShareSource("AAA", "BBB");

        new Thread(()->{
            shareSource.methodA();
        },"线程1").start();

        new Thread(()->{
            shareSource.methodB();
        },"线程2").start();

    }
}
