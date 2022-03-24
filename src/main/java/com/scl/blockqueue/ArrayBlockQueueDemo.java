package main.java.com.scl.blockqueue;

import java.sql.Time;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @description: blockqueuedemo 1.什么叫阻塞队列-》队列：一种数据结构FIFO  阻塞:队列为空阻塞，队列满了阻塞
 * 2.共有7种阻塞队列，常用的有3中  ArrayBlockQueue/LinkedBlockQueue/SychronusBlockQue
 *   ArrayBlockQueue有界队列初始为10  LinkedBlockQueue 有界队列，相当于无界 大小为 Integer.MAX_VALUE 21个亿
 *   SychronusBlockQueue相当于私人订制，进一个出一个，大小只有一个
 * 3.关于ArrayBlockQueue 它本身的出队和入队api有很多种  抛异常的有 add() remove() element()
 *                                                  不抛异常的有 offer() poll() peek()
 *                                                  定长阻塞 offer(obj,TimeUnit.SECOND,2)  poll()。。
 *                                                  无限时间  put() take()
 *
 * @author: shanglimin888@163.com
 * @time: 2021/9/29 10:58
 */
public class ArrayBlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

        //抛异常的
        /*queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("e");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());*/
        //不抛异常的
       /*queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.peek());*/

       //设置阻塞时间，若队列不为空，或者不为满，不会阻塞
        /*queue.offer("a",1, TimeUnit.SECONDS);
        queue.offer("b",1, TimeUnit.SECONDS);
        queue.offer("c",1, TimeUnit.SECONDS);
        queue.offer("d",3, TimeUnit.SECONDS);
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(3, TimeUnit.SECONDS));*/

       //无限期阻塞的
        /*ArrayBlockingQueue queue1 = new ArrayBlockingQueue<>(3);
        queue1.put("a");
        queue1.put("b");
        queue1.put("c");

        System.out.println(queue1.take());
        System.out.println(queue1.take());
        System.out.println(queue1.take());
        System.out.println(queue1.take());*/

        //add remove   offer poll  put take

    }
}    