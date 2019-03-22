package com.asispay.gaven.SimpleThread.wait.service;

public class WaitThread extends Thread{

    private Object lock;

    public WaitThread(Object lock) { //保证同一个对象锁
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }





}
