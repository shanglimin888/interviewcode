package com.scl.thread.interview;

/**
 * @description:
 * @author: shanglimin888@163.com
 * @time: 2021/8/3 15:01
 */
public class wine {
    public void fun1(){
        System.out.println("wine fun1");
        fun2();
    }

    public void fun2(){
        System.out.println("wine fun2");
    }
}

class JNC extends wine{
    public void fun1(String a){
        System.out.println("jnc fun1");
        fun2();
    }

    public void fun2(){
        System.out.println("jnc fun2");
    }

    public static void main(String[] args){
        wine wine = new JNC();
    }
}