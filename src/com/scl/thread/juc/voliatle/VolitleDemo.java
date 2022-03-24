package com.scl.thread.juc.voliatle;

import java.util.concurrent.TimeUnit;

class voShareSource{
    protected volatile boolean flag = false;
    //volatile private boolean flag = false;
    public void setFlag(boolean flag){
        this.flag = flag;
    }
}

/**
 * 验证volitle
 */
public class VolitleDemo {
    public static void main(String[] args) {
        voShareSource vo = new voShareSource();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vo.setFlag(true);
        }).start();


        new Thread(()->{
            while (!vo.flag){
            }
            System.out.println("hello world");
        }).start();


    }
}
