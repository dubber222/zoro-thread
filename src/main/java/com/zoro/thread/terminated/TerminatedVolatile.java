package com.zoro.thread.terminated;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2018/8/13.
 *
 * @author dubber
 */
public class TerminatedVolatile {


    private static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            int i= 0;
            while(!flag){
                i++;
            }
            System.out.println(i);
        });

        thread.start();
        System.out.println("begin start thread");
        TimeUnit.SECONDS.sleep(1);
        flag = true;
    }
}
