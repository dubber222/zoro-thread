package com.zoro.thread2;

/**
 * Created on 2018/8/20.
 * javap 探讨jvm monitor指令
 *
 * @author dubber
 */
public class Test {
    public static String a = "";
    public int i = 0;

    public Test() {
        int i = 0;
        String a = "xyz";
    }

    public static void main(String[] args) {
        a = "xyz++";
    }
}
