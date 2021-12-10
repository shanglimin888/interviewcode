package main.java.com.scl.thread.intrinsiclock;

/**
 * @description: 同步
 * sychonized 修饰静态方法  运行时类对象 为锁对象
 * @author: shanglimin888@163.com
 * @time: 2021/6/7 17:31
 */
public class Test09 {
    public static void main(String[] args){


        Test09 test = new Test09();
        Test09 test02 = new Test09();
        Test09 test03 = new Test09();
        new Thread(()->{

            test.mm2();
        },"t1").start();

        new Thread(()->{
            test02.mm2();       //this 对象就是 test
        },"t2").start();

        new Thread(()->{
            test03.mm2();       //this 对象就是 test
        },"t3").start();
    }


    public void mm(){
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }

    public synchronized static  void mm2(){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
                if(i == 50){
                    Integer.parseInt("abc");
                }
            }
    }


    //和上面效果一样，运行时类对象，简单理解为字节码文件，有人称为类锁
    public  void mm3(){
        synchronized (Test09.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+ "- ->" + i);
            }
        }
    }

}    