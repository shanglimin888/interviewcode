package com.scl.thread.threadlocal;

import java.util.Date;
import java.util.Random;

/**
 * @description: ThreadLocal初始值
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 13:52
 */
public class Test03 {

    static class SubThreadLocal extends ThreadLocal<Date>{
        @Override
        protected Date initialValue() {
            return new Date(System.currentTimeMillis()-1000*60*15);
        }
    }

    static SubThreadLocal threadLocal = new SubThreadLocal();

    static class SubThread extends Thread{
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"value is "+threadLocal.get());
                if(threadLocal.get() == null){
                    threadLocal.set(new Date());
                }
            }
            try {
                Thread.sleep(new Random(500).nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args){
        new SubThread().start();
        new SubThread().start();
    }
}    