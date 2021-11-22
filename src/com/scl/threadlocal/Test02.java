package com.scl.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @description: ThreadLocal的基本使用
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 13:52
 */
public class Test02 {
     static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<>();

     static class SubRunnable implements Runnable{
         private  int i = 0;
         public SubRunnable(int i){
             this.i = i;
         }


         @Override
         public void run() {
             try {
                 String text = "2068年11月22日 9:38:"+ i%60;

                 if(sdf.get() == null){
                     sdf.set(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
                 }

                 Date parse = sdf.get().parse(text);
                 System.out.println(parse);
             } catch (ParseException e) {
                 e.printStackTrace();
             }
         }
     }

    public static void main(String[] args){

        for (int i = 0; i < 60; i++) {
           new Thread(new SubRunnable(i)).start();
        }


    }
}    