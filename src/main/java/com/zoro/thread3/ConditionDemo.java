package com.zoro.thread3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/9/3
 */
public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        new ConditionDemo().demo();
    }

    public void demo() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new ConditionWait(lock, condition)).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new ConditionSignal(lock, condition)).start();
    }
}
