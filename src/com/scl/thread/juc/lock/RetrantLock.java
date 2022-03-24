package com.scl.thread.juc.lock;

class RshareSource{


    public synchronized void methodA(){
        System.out.printf("hello\t");
        methodB();
    }

    public synchronized void methodB(){
        System.out.println("world");
    }


}


/**
 * 可重入锁验证
 */
public class RetrantLock {
    public static void main(String[] args) {
        RshareSource source = new RshareSource();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                source.methodB();
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                source.methodA();
            }).start();
        }


    }


}
