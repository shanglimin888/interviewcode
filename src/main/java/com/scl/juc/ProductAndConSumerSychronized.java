package main.java.com.scl.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 生产者将*===》-    消费者将-===》*
 * @author: shanglimin888@163.com
 * @time: 2021/10/21 16:35
 */
public class ProductAndConSumerSychronized {
    public static void main(String[] args) throws InterruptedException {
        List  str =  new ArrayList(){{add("*");}};

        for (int i = 0; i < 5; i++) {
            new Thread(new product(str)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new consumer(str)).start();
        }

        //Thread.sleep(3000);

        //Thread.currentThread().sleep(10000);

    }
}


class product implements Runnable{

    private List str;

    public product(List str){
        this.str =str;
    }


    @Override
    public  void run() {
        synchronized (str){
            while (!str.get(0).equals("*")){
                try {
                    str.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产者"+str);
            str.remove("*");
            str.add("-");
            str.notifyAll();
        }


    }
}

class consumer implements Runnable{

    private  List str;

    public consumer(List str){
        this.str =str;
    }


    @Override
    public  void run() {
            synchronized (str){
                while (!str.get(0).equals("-")){
                    try {
                        str.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者"+str);
                str.remove("-");
                str.add("*");
                str.notifyAll();
            }
    }
}