package com.asispay.gaven.SimpleThread.security;

import java.util.concurrent.TimeUnit;


public class VisableDemo {


    //可见性问题，volatile保证可见性但不保证原子性，当共享内存的值在其中一个线程改变时，可以使其他cpu高速缓存的值失效，再去共享内存里面取
    //private  static  boolean stop=false;
    private  static volatile boolean stop=false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            int i=0;
            while(!stop){
                i++;
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        stop=true;
    }
}
