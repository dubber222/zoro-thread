package com.zoro.thread3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/26
 */
public class Demo {
    private static int count = 0;


    private static Lock lock = new ReentrantLock();

    public Demo() {

        synchronized (this) {

        }
    }

    public synchronized static void incr() {
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            countDownLatch.countDown();
        }, "t1").start();
        new Thread(() -> {
            countDownLatch.countDown();
        }, "t2").start();
        new Thread(() -> {
            countDownLatch.countDown();
        }, "t3").start();

        countDownLatch.await();
        System.out.println("所有的线程执行完毕！");
    }
}