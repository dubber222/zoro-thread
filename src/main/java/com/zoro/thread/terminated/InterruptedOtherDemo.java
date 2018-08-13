package com.zoro.thread.terminated;

import java.util.concurrent.TimeUnit;

/**
 * 01 终止线程复位
 * <p>
 * 通过抛出 InterruptedException 异常，复位标志位
 *
 * @author dubber
 * @date 2018/8/12
 */
public class InterruptedOtherDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while(true){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();// 设置复位标志位true
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.isInterrupted()); //false
    }
}
