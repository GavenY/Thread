package com.asispay.gaven.SimpleThread.wait.service;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        WaitThread a = new WaitThread(lock);
        a.start();

        //NotifyThread notifyThread = new NotifyThread(lock);
        // notifyThread.start();

        NotifyThread c = new NotifyThread(lock);
        c.start();

    }


}