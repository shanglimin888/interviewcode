package main.java.com.scl.thread.threadpool;

import java.util.concurrent.RecursiveTask;

/**
 * @description: 演示fockjoinpool线程池的使用
 *  使用该线程池模拟数列求和
 * @author: shanglimin888@163.com
 * @time: 2021/8/2 10:07
 */
public class Test09 {
    //计算数列的和，需要返回结果，可以继承recursiveTask
    private static class CountTask extends RecursiveTask<Long>{
        private static final int THRESHOLD = 10000;//定义数据规模阈值，超过就需要分解
        @Override
        protected Long compute() {
            return 0L;
        }
  