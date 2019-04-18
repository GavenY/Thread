package com.asispay.gaven.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {

        //读锁共享， 写锁排他，
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();



        Map<String,String> map = new HashMap<>();
        map.put("ss","cloud");


        new Thread(()->{

            writeLock.lock();
            try {

                System.out.println(Thread.currentThread().getName()+"---> 写入"+map.put("ss","asd"));
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
                writeLock.unlock();
            }
            writeLock.unlock();
        }).start();

        Thread.sleep(1000);

        for (int i = 0; i < 100; i++) {
            new Thread(()->{

                readLock.lock();
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"---> 读取 ："+map.get("ss"));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    readLock.unlock();
                }
                readLock.unlock();
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(()->{

                readLock.lock();
                try {
                    System.out.println("jinru");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"---> 读取 ："+map.get("ss"));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    readLock.unlock();
                }
                readLock.unlock();
            }).start();
        }




        }



}
