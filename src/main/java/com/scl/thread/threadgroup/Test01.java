package main.java.com.scl.thread.threadgroup;

/**
 * @description: 新建线程组
 * @author: shanglimin888@163.com
 * @time: 2021/7/13 9:45
 */
public class Test01 {
    public static void main(String[] args){
        //返回main线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup);

        //定义线程组,如果不指定所属线程组,则自动归属当前线 程所属的线程组中
        ThreadGroup group1 = new ThreadGroup("group1");
        System.out.println(group1);

        //定义线程组，同时指定父线程组
        ThreadGroup group2 = new ThreadGroup(mainGroup, "group2");
        System.out.println(group2);

        //现在 group1 与 group2 都是 maingroup 线程组中的子线程 组, 调用线程组的 getParent()方法返回父线程组
        System.out.println(group1.getParent() == group2.getParent());
        System.out.println(group1.getParent() == mainGroup);

        //在创建线程时指定所属线程组
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        Thread t3 = new Thread(r, "t3");
        Thread t4 = new Thread(group1, r, "t4");
        System.out.println(t3);
        System.out.println(t4);

    }
}    