package main.java.com.scl.thread.cas;

/**
 * @description: 使用CAS算法实现线程安全的计数器
 * @author: shanglimin888@163.com
 * @time: 2021/6/8 17:00
 */
public class CASTest {
    public static void main(String[] args){

        CAScounter counter = new CAScounter();

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(counter.incrementAndGet());
                }
            }).start();
        }


    }
}
class CAScounter{
    //将value线程可见
    volatile private long value;

    //CAS方法
    public boolean compareAndSwap(long expectValue,long newValue){
        synchronized (this){
            //如果期望的值和现在的值一致，将现在的值更新
            if(expectValue == this.value){
                this.value = newValue;
                return true;
            }else{
                return false;
            }
        }
    }

    //自增方法
    public long incrementAndGet(){
        long expectValue;
        long newValue;
        do{
            expectValue = this.value;
            newValue = expectValue+1;
        }while (!compareAndSwap(expectValue,newValue));
        return newValue;
    }






}