package com.scl.thread.hook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * @description: 通过hook线程防止程序重复启动
 * @author: shanglimin888@163.com
 * @time: 2021/7/13 22:13
 */
public class Test01 {
    public static void main(String[] args){
        //1)注入hook线程，在程序退出时，删除.lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("JVM退出中。。。启动hook线程删除.lock文件");
                getLockFile().toFile().delete();
            }
        }));

        //2)程序运行时，检查.lock文件是否存在
        if(getLockFile().toFile().exists()){
            throw new RuntimeException("程序已启动。。。");
        }else{
            //第一次启动，新建一个.lock文件
            try {
                getLockFile().toFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //3)模拟程序运行
        for (int i = 0; i < 10; i++) {
            System.out.println("程序正在运行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private static Path getLockFile() {
        return Paths.get("","temp.lock");
    }
}    