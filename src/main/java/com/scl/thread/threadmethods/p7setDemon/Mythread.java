package main.java.com.scl.thread.threadmethods.p7setDemon;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 15:07
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        for (;;) {
            System.out.println("sum thread");
        }
  