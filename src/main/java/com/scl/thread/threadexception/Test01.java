package main.java.com.scl.thread.threadexception;

/**
 * @description: 演示设置线程的unCatchExceptionHandler 回调接口
 * @author: shanglimin888@163.com
 * @time: 2021/7/13 16:18
 */
public class Test01 {
    public static void main(String[] args){
        //1)设置线程全局的回调接口
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //t参数接收发生异常的线程,e就是该线程中的异常
                System.out.println(t.getName()+"发生了异常如下："+e.getMessage());
            }
        });

        Thread t1= new Thread("t1"){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();//受检异常可以捕获
                }

                int i = 12/0;//math异常
            }
        };

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String s = null;
                int i = s.length();

            }
        },"t2");

        t2.start();
    }
}    