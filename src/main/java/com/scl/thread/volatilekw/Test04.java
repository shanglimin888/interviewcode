package main.java.com.scl.thread.volatilekw;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 使用原子类自增
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 21:33
 */
public class Test04 {

    public static void main(String[] args){

       for (int i=0;i<100;i++){
           new MyThreadd().start();
       }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("最终结果"+ MyThreadd.count);
        }


    }

    static class MyThreadd extends Thread{

         public  static AtomicInteger count = new AtomicInteger();


           static public  void addCount(){
            for (int i = 0; i < 100; i++) {
                count.getAndIncrement();
            }

               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+ " "+count.get());
        }


        @Override
        public void run() {
            addCount();
        }
    }
