package com.scl.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: threadPool 线程池的基本使用
 * @author: shanglimin888@163.com
 * @time: 2021/7/21 15:53
 */
public class Test01 {
    public static void main(String[] args){
        //创建5个线程大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //for循环18次，模拟有18个任务，打印效果查看线程池中线程执行任务的情况
        for (int i = 0; i < 18; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is execute the run task "+System.currentTimeMillis());
                    try {
                        Thread.sleep(1000);//模拟任务执行时长
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}    