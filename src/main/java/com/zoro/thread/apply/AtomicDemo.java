package com.zoro.thread.apply;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2018/9/6.
 *
 * @author dubber
 */
public class AtomicDemo implements Runnable {

    static ExecutorService service = Executors.newFixedThreadPool(1);
    // static ExecutorService service = Executors.newSingleThreadExecutor();

    private int num;

    public AtomicDemo(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            service.execute(new AtomicDemo(i));
        }
        service.shutdown();
    }


    @Override
    public void run() {
        try {
            System.out.println(num + "开始处理线程！");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (num == 20)
            throw new IllegalStateException();
        System.out.println(Thread.currentThread().getName() + "线程标识:" + this.toString());
    }
}
