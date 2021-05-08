package com.zoro.thread.grace;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 保存处理结果
 *
 * @author dubber
 * @date 2018/8/12
 */
public class SaveProcessor extends Thread implements RequestProcessor {
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private RequestProcessor nextProcessor;

    public SaveProcessor(){
    }

    public SaveProcessor(RequestProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run(){
        while(true){
            try {
                Request request = requests.take();
                System.out.println("save data：" + request.getName());
                /*nextProcessor.processRequest(request);*/
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
