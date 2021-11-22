package com.scl.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: 线程池的计划任务
 * @author: shanglimin888@163.com
 * @time: 2021/7/21 16:28
 */
public class Test02 {
    public static void main(String[] args){
        //创建一个有调度功能的线程池
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);

        //这个任务执行一次，延时两秒
       /* ses.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + " say hello "+System.currentTimeMillis());
            }
        },2, TimeUnit.SECONDS);*/

       /*//以固定时间循环执行任务，3秒循环一次，延时2秒
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + " say hello "+System.currentTimeMillis());
                try {
                    //如果任务执行时长超过了时间间隔，则立即执行下一个任务
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },2,3,TimeUnit.SECONDS);*/

       ses.scheduleWithFixedDelay(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getId() + " say hello "+System.currentTimeMillis());
               try {
                   TimeUnit.SECONDS.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       },3,3,TimeUnit.SECONDS);

    }
}    