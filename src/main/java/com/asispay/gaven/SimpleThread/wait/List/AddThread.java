package com.asispay.gaven.SimpleThread.wait.List;

public class AddThread extends  Thread {

    private Add add;

    public AddThread(Add a) { //保证同一个对象锁
        super();
        this.add = a;
    }

    @Override
    public void run() {
        super.run();
        add.add();
    }
}
