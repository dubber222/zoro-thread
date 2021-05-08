package com.zoro.thread.apply;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2018/9/6.
 *
 * @author dubber
 *         <p>
 *         信号灯
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i <= 10; i++) {
            new car(i, semaphore).start();
        }
    }
}

class car extends Thread {

    private int num;
    private Semaphore semaphore;

    public car(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        //获得许可证
        try {
            semaphore.acquire();
            System.out.println("1 第" + num + "辆车，in！");

            TimeUnit.SECONDS.sleep(2);
            System.out.println("2 第" + num + "辆车，out！");
            //释放许可证
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
