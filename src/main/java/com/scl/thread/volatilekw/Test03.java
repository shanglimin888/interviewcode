package main.java.com.scl.thread.volatilekw;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: volatile可以保证数据在线程间的可见性，却无法保证原子性
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 21:33
 */
public class Test03 {

    public static void main(String[] args){

       for (int i=0;i<100;i++){
           new MyThreadd().start();
       }

    }

    static class MyThreadd extends Thread{

         public static AtomicInteger count = new AtomicInteger();


           static public  void addCount(){
            for (int i = 0; i < 100; i++) {
                count.getAndIncrement();
            }

               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+ " "+count);
        }


        @Override
        public void run() {
            addCount();
        }
    }



}    