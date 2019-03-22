package com.asispay.gaven.SimpleThread.wait.List;

public class TwoThreadNotifyTest {

    public static void main(String[] args) {

        Object lock = new Object();



        AddThread addThread = new AddThread(new Add(lock));
        addThread.setName("add");

        SubThread subThread = new SubThread(new Sub(lock));
        subThread.setName("sub1");

        SubThread subThread2 = new SubThread(new Sub(lock));
        subThread2.setName("sub2");

        subThread2.start();
        subThread.start();
        addThread.start();


    }
}
