package com.zoro.thread.state;

import java.util.concurrent.TimeUnit;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/12
 */
public class ThreadState {

    public static void main(String[] args) {

        new Thread(()->{
            // TIME_WAITING
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"TIME_WAITING").start();

        new Thread(()->{
            // WAITING   获取 ThreadState 类锁，通过wait进行等待
            while(true){
                synchronized (ThreadState.class){
                    try {
                        ThreadState.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"WAITING").start();

        new Thread(new BlockedDemo(), "BlockedDemo_0").start();
        new Thread(new BlockedDemo(), "BlockedDemo_1").start();
    }

    static class BlockedDemo implements Runnable{
        @Override
        public void run(){
            while(true){
                synchronized(BlockedDemo.class){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
