package com.zoro.thread.grace;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/12
 */
public class ProcessorTest {

    static PrintProcessor printProcessor;

    static {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("安安小公主");
        printProcessor.processRequest(request);
    }
}
