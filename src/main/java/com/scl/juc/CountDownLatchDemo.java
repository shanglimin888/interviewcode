package main.java.com.scl.juc;

import main.java.com.scl.enumpac.SeaSon;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 演示countDownlatch
 * countDownLatch就是倒计时，做减法，秦灭六国，一统华夏
 * @author: shanglimin888@163.com
 * @time: 2021/9/29 9:42
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(4);

        for (int i = 1; i <=4; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t走了");
                c.countDown();
            }, SeaSon.getSeasonByCode(i).getName()).start();
        }
        c.await();
        System.out.println("要过年了哦");

    }
}    