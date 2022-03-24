package main.java.com.scl.juc;

import main.java.com.scl.enumpac.SeaSon;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: 可循环屏障，和countdownlatch类似，做加法
 * @author: shanglimin888@163.com
 * @time: 2021/9/29 9:48
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier c = new CyclicBarrier(4, () -> {
            System.out.println("要过年咯");
        });
        for (int i = 1; i <= 4; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t走了");
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, SeaSon.getSeasonByCode(i).getName()).start();
        }


    }
}    