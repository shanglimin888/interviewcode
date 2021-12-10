package main.java.com.scl.thread.producerstack;

/**
 * @description: 提供者调用栈的pop方法
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 14:34
 */
public class ProducerStackThread extends Thread{
    private StackOP obj;
    public ProducerStackThread(StackOP obj){
        this.obj= obj;
    }
    @Override
    public void run() {
        while (true){
            obj.push();
        }
    }
}