package com.scl.thread.juc.cas;

import java.util.concurrent.atomic.AtomicReference;

class DataSource{
    AtomicReference data = new AtomicReference();

    //上锁
    protected void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t准备上锁");
        while (!data.compareAndSet(null,thread)){
        }
        System.out.println(thread.getName()+"\t上锁结束");
    }


    //解锁
    protected void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t准备解锁");
        while (!data.compareAndSet(thread,null)){
        }
        System.out.println(thread.getName()+"\t解锁成功");
    }
}


/**
 * 实现一个自旋锁
 */
public class SpinlockDemo {
    public static void main(String[] args) {
        DataSource data = new DataSource();

       /* new Thread(()->{
            try {
                data.lock();
                TimeUnit.SECONDS.sleep(2l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                data.unlock();
            }
        },"AAA").start();


        new Thread(()->{
            try {
                data.lock();
            }finally {
                data.unlock();
            }
        },"BBB").start();*/

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                data.lock();
                System.out.println("干活");
                data.unlock();
            },""+i).start();
        }

    }




}
