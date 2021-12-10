package main.java.com.scl.thread.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: conditon 等待通知 生产者消费者  多对多 交替打印
 * @author: shanglimin888@163.com
 * @time: 2021/7/6 21:05
 */
public class Test04 {
    static class Myservice{
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        boolean flag = true;

        //打印 ==========
        public void printA(){
            try {
                lock.lock();
                while (flag){
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+" is waitting");
                }
                System.out.println(Thread.currentThread().getName()+"===============");
                flag=true;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        //打印 *********
        public void printB(){
            try {
                lock.lock();
                while (!flag){
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+" is waitting");
                }
                System.out.println(Thread.currentThread().getName()+"*********");
                flag=false;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        Myservice myservice = new Myservice();

        for (int i =0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        myservice.printA();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        myservice.printB();
                    }
                }
            }).start();
        }


    }

}    