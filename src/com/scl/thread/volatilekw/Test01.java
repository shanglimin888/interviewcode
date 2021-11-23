package com.scl.thread.volatilekw;

/**
 * @description: volatile保证 修饰的变量，能让所有参与的线程在公共内存中读取的到，而不是从工作内存中读取
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 21:33
 */
public class Test01 {

    public static void main(String[] args){
        printClass printClass = new printClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printClass.printMethod();

            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在mian线程中修改打印标志");
        printClass.setIfprint(false);
    }


    static class printClass{
        private  volatile    boolean ifprint = true;

        public void setIfprint(boolean ifprint){
            this.ifprint = ifprint;
        }


        public void printMethod(){
           System.out.println(Thread.currentThread().getName()+" 开始");
           while(ifprint){
           }
            System.out.println(Thread.currentThread().getName()+" 结束");

        }
    }

}    