package com.asispay.gaven.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {



    public static void main(String[] args) throws InterruptedException {


        //原子incn
        AtomicInteger atomicInteger  = new AtomicInteger(0);

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{

                 atomicInteger.incrementAndGet();

            }).start();
        }

        Thread.sleep(1000);

        System.out.println(atomicInteger.get());
    }

}
