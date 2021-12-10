package main.java.com.scl.thread.wait;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/6/14 22:14
 */
public class Test02 {
    public static void main(String[] args){
        String text ="shagnlimin";
        System.out.println("同步前的代码");
        try {
            synchronized (text){
            System.out.println("同步开始前");
            text.wait();
                System.out.println("wait方法后");
            }
            System.out.println("同步后的代碼");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main后的代碼");


    }
}    