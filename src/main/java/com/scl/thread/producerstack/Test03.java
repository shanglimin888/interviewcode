package main.java.com.scl.thread.producerstack;

/**
 * @description: 模拟 多提供者多消费者 共享栈
 *
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 10:11
 */
public class Test03 {
    public static void main(String[] args){
        StackOP obj = new StackOP();
        ProducerStackThread p1 = new ProducerStackThread(obj);
        ProducerStackThread p2 = new ProducerStackThread(obj);
        ProducerStackThread p3 = new ProducerStackThread(obj);
        ConsumerStackThread c1 = new ConsumerStackThread(obj);
        ConsumerStackThread c2 = new ConsumerStackThread(obj);
        ConsumerStackThread c3 = new ConsumerStackThread(obj);



        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();



    }
}    