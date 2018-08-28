package com.zoro.thread.terminated;

import com.zoro.thread.thread;

import java.util.concurrent.TimeUnit;

/**
 * 01 终止线程复位
 * interrupted() 方法
 *
 * @author dubber
 * @date 2018/8/12
 */
public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().interrupt();
        System.out.println("normal " + Thread.currentThread().isInterrupted());
        System.out.println("before " + Thread.interrupted());
        System.out.println("after " + Thread.currentThread().isInterrupted());
        System.out.println("end");
    }
}
