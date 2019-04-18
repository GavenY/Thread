package com.asispay.gaven.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {

    public static void main(String[] args) {

        //允许三个通行证，共享锁，运行多少线程运行
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 100; i++) {
            new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "----> Runing");
                    Thread.sleep(1000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }

}
