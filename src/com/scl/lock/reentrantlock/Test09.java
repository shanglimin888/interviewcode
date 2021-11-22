package com.scl.lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用 trylock() 可以避免死锁
 * @author: shanglimin888@163.com
 * @time: 2021/6/23 9:27
 */
public class Test09 {

    static class IntLock implements Runnable{

        private ReentrantLock lock1= new ReentrantLock();
        private ReentrantLock lock2= new ReentrantLock();

        private int num;

        public IntLock(int num){
            this.num = num;
        }

        @Override
        public void run() {

            if(num%2==0){//如果是偶数，先获得锁1 然后尝试获得 锁2
                while(true){
                    try {
                        if(lock1.tryLock()){
                            System.out.println(Thread.currentThread().getName()+" 获得锁1，尝试获得锁2");
                            Thread.sleep(new Random().nextInt(1000));
                        }else{
                            try {
                                if(lock2.tryLock()){
                                    System.out.println(Thread.currentThread().getName()+" 获得锁1，又获得了锁2 任务结束");
                                    return;
                                }
                            } finally {
                                if(lock2.isHeldByCurrentThread())
                                    lock2.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if(lock1.isHeldByCurrentThread())
                            lock1.unlock();
                    }
                }

            }else{  //奇数
                while(true){
                    try {
                        if(lock2.tryLock()){
                            System.out.println(Thread.currentThread().getName()+" 获得锁2，尝试获得锁1");
                            Thread.sleep(new Random().nextInt(1000));
                        }else{
                            try {
                                if(lock1.tryLock()){
                                    System.out.println(Thread.currentThread().getName()+" 获得锁2，又获得了锁1 任务结束");
                                    return;
                                }
                            } finally {
                                if(lock1.isHeldByCurrentThread())
                                    lock1.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if(lock1.isHeldByCurrentThread())
                            lock1.unlock();
                    }
                }
            }



        }
    }

    public static void main(String[] args){
        IntLock intLock1 = new IntLock(11);
        IntLock intLock2 = new IntLock(22);

        Thread t1 = new Thread(intLock1);
        Thread t2 = new Thread(intLock2);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }

}    