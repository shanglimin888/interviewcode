package main.java.com.scl.thread.threadmethods.p5yieldAndSetPriorty;

/**
 * @description:  thread.setPrioty(1-10) 表示给线程设置优先级，类似于使争夺时间片的概率变大
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:42
 */
public class Test {
    public static void main(String[] args){
        Mythread t = new Mythread();
        t.start();
        t.setPriority(1);
        Thread.currentThread().setPriority(10);
        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("main线程总计耗时"+(end-start));
    }
}    