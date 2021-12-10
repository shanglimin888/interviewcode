package main.java.com.scl.thread.producerstack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 使用list模拟栈
 * 定义两个方法：pop&push
 * pop:只要栈中数据小于max 就往里放数据
 * push:只要栈中数据不为空就取数据
 * @author: shanglimin888@163.com
 * @time: 2021/6/17 14:20
 */
public class StackOP {

    private List list = new ArrayList();
    public  final int MAX = 1;

    synchronized public void push(){
        if(MAX<=list.size()){
            try {
                System.out.println(Thread.currentThread().getName()+" 放入数据开始等待");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String data = "data" +" "+ Math.random();
        list.add(data);
        System.out.println(Thread.currentThread().getName()+" 向栈中放入了数据" +data);
        this.notifyAll();
    }

    synchronized public void pop(){
        while(list.size()<=0){
            try {
                System.out.println(Thread.currentThread().getName()+" 取出数据开始等待");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+ "从栈中取出数据是 "+ list.remove(0));
        this.notifyAll();
    }





}    