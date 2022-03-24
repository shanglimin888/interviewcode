package main.java.com.scl.thread.producerdata;

/**
 * @description: 模拟多生产多消费的场景
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 16:49
 */
public class Test2 {
    public static void main(String[] args){
        ValueOP obj = new ValueOP();
        ProducerThread producerThread1 = new ProducerThread(obj);
        ProducerThread producerThread2 = new ProducerThread(obj);
        ProducerThread producerThread3 = new ProducerThread(obj);
        ConsumerThread consumerThread1 = new ConsumerThread(obj);
        ConsumerThread consumerThread2 = new ConsumerThread(obj);
        ConsumerThread consumerThread3 = new ConsumerThread(obj);

        //多生产多消费
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
    }
}    