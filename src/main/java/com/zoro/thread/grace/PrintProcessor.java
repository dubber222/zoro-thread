package com.zoro.thread.grace;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 处理结果
 *
 * @author dubber
 * @date 2018/8/12
 */
public class PrintProcessor extends Thread implements RequestProcessor {
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();
    private final RequestProcessor nextProcessor;
    public PrintProcessor(RequestProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }
    @Override
    public void run(){
        while(true){
            try {
                Request request = requests.take();
                System.out.println("print data：" + request.getName());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 处理请求
    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
