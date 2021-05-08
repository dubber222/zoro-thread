package com.zoro.thread.apply;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2018/9/4.
 *
 * @author dubber
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println("哈哈哈哈");
            }, "thread" + i).start();
        }
        boolean flag = countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("main方法执行完毕！！ flag ==> " + flag);
    }
}

