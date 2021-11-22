package com.scl.producerstack;

/**
 * @description: 模拟 单提供者多消费者 共享栈
 *  将栈的push 方法 if判断变成while循环判断 解决下标越界
 *
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 10:11
 */
public class Test02 {
    public static void main(String[] args){
        StackOP obj = new StackOP();
        ProducerStackThread p1 = new ProducerStackThread(obj);
        ConsumerStackThread c1 = new ConsumerStackThread(obj);
        ConsumerStackThread c2 = new ConsumerStackThread(obj);
        ConsumerStackThread c3 = new ConsumerStackThread(obj);

        //步骤：1.三个消费者都去消费发现没有数据，wait
        //      2.一个提供者发现没有数据，放入数据 调用notify 正好通知到了自己，然后放入数据，wait 导致所有的线程都在等待了
        //      这种情况称为假死，解决就是将notify 改为 notifyAll 即可

        c1.start();
        c2.start();
        c3.start();
        p1.start();



    }
}    