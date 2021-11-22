package com.scl.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 监控线程池
 * @author: shanglimin888@163.com
 * @time: 2021/7/22 15:02
 */
public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        //先定义任务
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("编号为"+Thread.currentThread().getId()+"开始执行任务了");
                try {
                    TimeUnit.SECONDS.sleep(10); //睡眠几秒模拟任务执行时长
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //定义线程池
        ThreadPoolExecutor tpExecutor = new ThreadPoolExecutor(2,5,0,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        
        //向线程池中提交30个任务
        for (int i = 0; i < 30; i++) {
            tpExecutor.submit(r);
            System.out.println(" 当 前 线 程 池 核 心 线 程 数 量 : " + tpExecutor.getCorePoolSize() +
                    ", 最大线程数:" + tpExecutor.getMaximumPoolSize() +
                    ",当 前 线 程 池 大 小 :" + tpExecutor.getPoolSize() +
                    ", 活 动 线 程 数 量 :" + tpExecutor.getActiveCount()+
                    ",收到任务数量:" + tpExecutor.getTaskCount() +
                    ",完成任务 数 : " + tpExecutor.getCompletedTaskCount() +
                    ", 等 待 任 务 数 :" + tpExecutor.getQueue().size()) ;
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }
}    