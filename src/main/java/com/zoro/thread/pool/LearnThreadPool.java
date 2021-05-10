package com.zoro.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author chenershuai
 * @date 21-5-8 下午4:58
 */
public class LearnThreadPool {

    /**
     * BlockingQueue<Runnable> 阻塞队列, 作为任务队列，
     * ThreadFactory()接口，可以自定义线程(Thread(ThreadGroup group, Runnable target, String name,
     * long stackSize)  可以设置 线程组，任务，线程名称，线程占用栈大小)
     * RejectedExecutionHandler 拒绝执行策略
     */
    private ExecutorService diyService = new ThreadPoolExecutor(10, 100, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(50), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);

            return thread;
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());
    private ExecutorService cachedService = Executors.newCachedThreadPool();
    private ExecutorService scheduledService = Executors.newScheduledThreadPool(10);



    public static void main(String[] args) throws InterruptedException {
         // new LearnThreadPool().execute();


    }

    public void execute() {
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 151; i++) {
            int finalI = i;

           futures.add(diyService.submit(() -> {
                try {
                    Thread.sleep(  10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("走吧！----" + finalI);
            }));

        }



    }
}
