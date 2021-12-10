package main.java.com.scl.thread.producerdata;

import java.util.Hashtable;

/**
 * @description: 模拟一生产一消费场景
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 16:49
 */
public class Test {
    public static void main(String[] args){
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        ValueOP obj = new ValueOP();
        ProducerThread producerThread = new ProducerThread(obj);
        ConsumerThread consumerThread = new ConsumerThread(obj);

        //一生产一消费
        consumerThread.start();
        producerThread.start();
    }
}    