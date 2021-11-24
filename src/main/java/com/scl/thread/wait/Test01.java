package com.scl.thread.wait;

/**
 * @description: wait() 和 notify() 需要放在同步代码块中
 *               任何对象都可以调用这两个方法，但是 必须放在同步代码块中，否则会抛异常
 * @author: shanglimin888@163.com
 * @time: 2021/6/12 10:56
 */
public class Test01 {
    public static void main(String[] args){
        String text ="shanglimin";
        try {
            text.wait();  //illegalMonitorException异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}    