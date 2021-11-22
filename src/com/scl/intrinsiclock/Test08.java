package com.scl.intrinsiclock;



/**
 * @description: 脏读
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test08 {
    public static void main(String[] args) throws  Exception{

        user user = new user();
        MyThread t = new MyThread(user);
        t.start();
        Thread.sleep(100);

        user.getUser();
    }

    static class MyThread extends Thread{

        private user u;

        public MyThread(user u){
            this.u = u;
        }

        @Override
        public void run() {
            u.setUser("shangchunliang","123");
        }
    }


    static  class user{
        private String name ="shanglimin";
        private String pwd =  "666";


        public void setUser(String name,String pwd){
            try {
                this.name=name;
                Thread.sleep(3000);
                this.pwd = pwd;
                System.out.println(Thread.currentThread().getName()+"  name  "+name+"  pwd  "+pwd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public void getUser(){
            System.out.println(Thread.currentThread().getName()+"  name  "+name+"  pwd  "+pwd);

        }


    }

}    