package com.zoro.thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/9/3
 */
public class ConditionWait implements Runnable{
    private Lock lock;
    private Condition condition;
    public ConditionWait(Lock lock, Condition condition){
        this.lock=lock;
        this.condition=condition;
    }

    @Override
    public void run() {
        System.out.println("begin -ConditionDemoWait");
        try {
            lock.lock();
            condition.await();
            System.out.println("end - ConditionDemoWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}