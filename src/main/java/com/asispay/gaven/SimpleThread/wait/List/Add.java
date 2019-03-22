package com.asispay.gaven.SimpleThread.wait.List;

public class Add {

    private Object lock;
    public Add(Object lock) {
        super();
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            SingletonList.list.add("anyString");
            lock.notifyAll();
        }
    }

}
