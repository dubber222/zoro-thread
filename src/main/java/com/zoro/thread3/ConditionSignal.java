package com.zoro.thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/9/3
 */
public class ConditionSignal implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin -ConditionSignal");
        lock.lock();
        condition.signal();
        System.out.println("end - ConditionSignal");
        lock.unlock();
    }
}
