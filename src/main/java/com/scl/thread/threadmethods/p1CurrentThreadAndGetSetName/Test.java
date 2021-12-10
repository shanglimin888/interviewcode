package main.java.com.scl.thread.threadmethods.p1CurrentThreadAndGetSetName;

/**
 * @description:  线程的静态方法 Thread.CurrentThread ： 获取当前线程
 *                线程的普通方法  t.setName() 给线程一个名字   t.getName() 获取当前线程的名称
 * @author: shanglimin888@163.com
 * @time: 2021/6/4 14:15
 */
public class Test {
    public static void main(String[] args){
        System.out.println("当前线程是"+Thread.currentThread().getName());

        Mythread t = new Mythread();
        t.setName("shanglimin");
        t.start();
    }
}    