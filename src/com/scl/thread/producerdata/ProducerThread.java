package com.scl.thread.producerdata;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 9:22
 */
public class ProducerThread extends Thread {

    private ValueOP obj;

    public ProducerThread(ValueOP obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true){
            obj.setValue();
        }
    }
}