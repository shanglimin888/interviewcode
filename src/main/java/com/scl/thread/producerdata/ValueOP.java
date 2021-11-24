package com.scl.thread.producerdata;

/**
 * @description: 定义一个操作数据的类
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 16:49
 */
public class ValueOP {
    //初始化要操作的字符串
    private String value = "";

    //定义修改value的值
    public void setValue(){
        synchronized (this){
            while( !value.equalsIgnoreCase("")){//应该使用while,循环去判断字符串的状态
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String value = System.currentTimeMillis() +" - " + System.nanoTime();
            System.out.println(Thread.currentThread().getName()+" 设置的值是 "+ value);
            this.value =value;
            this.notifyAll();//多生产多消费环境下，notify不知道唤醒的是谁，若使用notify可能会造成假死的状态

        }
    }

    //定义读取value的值
    public void getValue(){
        synchronized (this){
            while(value.equalsIgnoreCase("")){//应该使用while,循环去判断字符串的状态
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() +" 读取的值是 "+ value);
            this.value = "";
            this.notifyAll();//多生产多消费环境下，notify不知道唤醒的是谁，若使用notify可能会造成假死的状态

        }
    }

}    