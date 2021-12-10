package main.java.com.scl.thread.wait;

/**
 * @description: wait(long)  到long时间后自动结束等待
 * @author: shanglimin888@163.com
 * @time: 2021/6/16 14:20
 */
public class Test07 {
    public static void main(String[] args){
        new Thread(new Runnable() {
             Object obj=new Object();
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        System.out.println("thread is wait start");
                        obj.wait(5000);
                        System.out.println("thread is wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}    