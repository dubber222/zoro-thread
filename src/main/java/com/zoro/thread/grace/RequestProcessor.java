package com.zoro.thread.grace;

/**
 * 处理request 请求
 *
 * @author dubber
 * @date 2018/8/12
 */
public interface RequestProcessor {
    void processRequest(Request request);
}
