package com.zoro.thread.apply;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2018/8/27.
 *
 * @author dubber
 */
public class ReentrantReadWriteLockDemo {
    static Map<String, Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    /**
     * final 方法，不可被重写
     *
     * @return
     */
    public static final Object get(String key) {
        readLock.lock();
        System.out.println("读锁，开始读数据……");
        Object o = null;
        try {
            TimeUnit.SECONDS.sleep(3);

            o = cacheMap.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return o;
    }

    /**
     * final 方法，不可被重写
     *
     * @return
     */
    public static final Object get2(String key) {
        readLock.lock();
        System.out.println("读锁，开始读数据2222……");
        Object o = null;
        try {
            TimeUnit.SECONDS.sleep(3);

            o = cacheMap.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return o;
    }

    /**
     * final 方法，不可被重写
     *
     * @return
     */
    public static final Object put(String key, Object obj) {
        writeLock.lock();
        System.out.println("写锁，开始写数据……");
        Object o = null;
        try {
            TimeUnit.SECONDS.sleep(3);
            o = cacheMap.put(key, obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
        return o;
    }


    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            Object o = ReentrantReadWriteLockDemo.get(String.valueOf(System.currentTimeMillis()));
        }).start();

        new Thread(() -> {
            Object o = ReentrantReadWriteLockDemo.get2(String.valueOf(System.currentTimeMillis()));
        }).start();

        new Thread(() -> {
            ReentrantReadWriteLockDemo
                    .put(String.valueOf(System.currentTimeMillis()), new String());
        }).start();

        TimeUnit.SECONDS.sleep(7);
    }
}
