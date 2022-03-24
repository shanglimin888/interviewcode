package main.java.com.scl.thread.threadpool;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 自定义拒绝策略
 * @author: shanglimin888@163.com
 * @time: 2021/7/22 14:21
 */
public class Test03 {
    public static void main(String[] args){

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

        //创建线程池，自定义拒绝策略
        ThreadPoolExecutor tpExecutor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                //r是请求的任务，executor是当前线程池
                System.out.println(r+" is discarding...");
            }
        });

        //向线程池提供若干任务
        for (int i = 0; i < 50; i++) {
            tpExecutor.submit(r);
        }
    }
}    