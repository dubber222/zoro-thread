package com.zoro.thread.terminated;

import java.util.concurrent.TimeUnit;

/**
 * 01 终止线程
 * interrupt() 方法
 *
 * @author dubber
 * @date 2018/8/12
 */
public class InterruptDemo {
    static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("num:" + i);
        },"interrupt_demo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
