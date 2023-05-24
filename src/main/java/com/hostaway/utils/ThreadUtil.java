package com.hostaway.utils;

public class ThreadUtil {

    public static void WAIT(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
