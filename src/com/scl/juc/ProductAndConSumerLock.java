package com.scl.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 生产者将*===》-    消费者将-===》*
 * @author: shanglimin888@163.com
 * @time: 2021/10/21 16:35
 */
public class ProductAndConSumerLock {
    public static void main(String[] args) throws InterruptedException {
        List  str =  new ArrayList(){{add("*");}};
        Lock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        for (int i = 0; i < 5; i++) {
            new Thread(new product1(str,condition,reentrantLock)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new consumer1(str,condition,reentrantLock)).start();
        }

        //Thread.sleep(3000);

        //Thread.currentThread().sleep(10000);

    }
}


class product1 implements Runnable{

    private List str;

    private Lock reentrantLock;

    private Condition condition;
    public product1(List str, Condition condition, Lock reentrantLock){
        this.str =str;
        this.condition=condition;
        this.reentrantLock = reentrantLock;
    }


    @Override
    public  void run() {

        try{
            reentrantLock.lock();
            while (!str.get(0).equals("*")){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产者"+str);
            str.remove("*");
            str.add("-");
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }




    }
}

class consumer1 implements Runnable{

    private List str;

    private Lock reentrantLock;

    private Condition condition;
    public consumer1(List str,Condition condition,Lock reentrantLock){
        this.str =str;
        this.condition=condition;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public  void run() {
        try {
            reentrantLock.lock();
            while (!str.get(0).equals("-")){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者"+str);
            str.remove("-");
            str.add("*");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


}