package com.scl.thread.juc.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger auto = new AtomicInteger();
        int andIncrement = auto.getAndIncrement();
        boolean b = auto.compareAndSet(0, 1);
        System.out.println(auto.compareAndSet(0, 1));
    }
}
