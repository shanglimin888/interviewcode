package com.scl.producerstack;

/**
 * @description: 消费者调用栈中的pop方法
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 14:34
 */
public class ConsumerStackThread extends Thread{

    private StackOP obj;

    public ConsumerStackThread(StackOP obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        while(true){
            obj.pop();
        }
    }
}