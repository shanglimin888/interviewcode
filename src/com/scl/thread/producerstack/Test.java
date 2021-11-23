package com.scl.thread.producerstack;

/**
 * @description: 模拟 单提供者单消费者 共享栈
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 10:11
 */
public class Test {
    public static void main(String[] args){
        StackOP obj = new StackOP();
        ProducerStackThread p1 = new ProducerStackThread(obj);
        ConsumerStackThread c1 = new ConsumerStackThread(obj);

        p1.start();
        c1.start();

    }
}    