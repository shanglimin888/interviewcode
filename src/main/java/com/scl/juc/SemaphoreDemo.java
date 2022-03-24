package main.java.com.scl.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: 信号灯  -》 停车场有三个车位，有三十个车辆，走一辆停一辆
 * 可以做限流，如果车位只有一个，就是锁的作用
 * @author: shanglimin888@163.com
 * @time: 2021/9/29 10:13
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    TimeUnit.SECONDS.sleep(3L);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "\t腾出车位");
                    semaphore.release();
                }
            }, i + "").start();
        }


    }

}    