package com.zoro.thread4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2018/8/27.
 *
 * @author dubber
 */
public class ReentrantLockDemo {

    private static int count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void incr() {
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch  countDownLatch = new CountDownLatch(3);

        new Thread(()->{
            countDownLatch.countDown();
        },"thread1").start();

        new Thread(()->{
            countDownLatch.countDown();
        },"thread2").start();

        new Thread(()->{
            countDownLatch.countDown();
        },"thread3").start();

        countDownLatch.await();
        System.out.println("main方法执行完毕！！");

    }

}
