package com.zoro.thread.grace;

/**
 * 请求
 *
 * @author dubber
 * @date 2018/8/12
 */
public class Request {
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
