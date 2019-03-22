package com.asispay.gaven.SimpleThread.wait.List;

public class SubThread extends  Thread {

    private Sub sub;

    public SubThread(Sub sub) { //保证同一个对象锁
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        super.run();
        sub.subNote();
    }
}
