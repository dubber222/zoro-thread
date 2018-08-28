package com.zoro.thread4;

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

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                ReentrantLockDemo.incr();
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("count==" + count);

    }

}
