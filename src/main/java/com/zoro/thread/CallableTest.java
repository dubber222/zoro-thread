package com.zoro.thread;

import java.util.concurrent.*;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/12
 */
public class CallableTest implements Callable<String> {
    static int i = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (i < 4) {
            Future<String> future = executorService.submit(new CallableTest());
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
    @Override
    public String call() throws Exception {
        ++i;
        return "执行结果" + i;
    }
}
