package com.asispay.gaven.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockDemo {
    static  int i = 0;

    public static void main(String[] args) throws InterruptedException {

        //可重入排他锁 ，类似synchroize 偏向锁减少线程切换
        ReentrantLock reentrantLock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        for (int j = 0; j < 1000; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    reentrantLock.lock();

                    i++;
                    countDownLatch.countDown();
                    reentrantLock.unlock();
                }
            }).start();
        }


        countDownLatch.await();
        System.out.println(i);
    }
}
