package com.asispay.gaven.SimpleThread.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i;

    //利用interrupted 优雅结束线程  // currentThread().isInterrupted() 初始时为false，当 thread.interrupt(); 变为true
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(i);
        });

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

    }

}
