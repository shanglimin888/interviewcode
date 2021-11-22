package com.scl.threadpool;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 自定义线程工厂
 * @author: shanglimin888@163.com
 * @time: 2021/7/22 14:42
 */
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        //定义任务
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int num = new Random().nextInt(5);
                System.out.println(Thread.currentThread().getId()+" - - 自定义睡眠"+ num+"秒");
                try {
                    TimeUnit.SECONDS.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //创建线程池，自定义线程工厂，默认拒绝策略是抛出异常
        ThreadPoolExecutor tpExecutor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                //根据r创建一个线程
                Thread t = new Thread(r);
                t.setDaemon(true);
                System.out.println("创建了线程"+t);
                return t;
            }
        });

        //提交5个任务，当给当前线程池提交的任务超过5个时，线程池会默认抛出异常
        for (int i = 0; i < 5; i++) {
            tpExecutor.submit(r);
        }

        //主线程休息10秒
        TimeUnit.SECONDS.sleep(10);
    }
}    