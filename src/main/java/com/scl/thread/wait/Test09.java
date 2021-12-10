package main.java.com.scl.thread.wait;

/**
 * @description: notify通知过早 找一种方法避免通知过早
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 14:28
 */
public class Test09 {
    static  boolean ifFirstStart = true;

    public static void main(String[] args){
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (ifFirstStart){
                        synchronized (lock){
                            System.out.println("start wait");
                            lock.wait();
                            System.out.println("end wait");
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("start notify");
                    lock.notify();
                    System.out.println("end notify");
                    ifFirstStart = false;
                }
            }
        });

      /*  t1.start();
        t2.start();*/

       t2.start();
       t1.start();


    }
}    