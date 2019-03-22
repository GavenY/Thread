package com.asispay.gaven.SimpleThread;

public class SynchronizedThread implements  Runnable{

    Object lock = new Object();

    volatile  int ticket = 50;




    @Override
    public void run() {




            while(ticket>0){
                synchronized(lock){
                    if(ticket>0){
                        ticket--;
                        System.out.println(Thread.currentThread().getName()+"售出一张票，还剩"+ticket);
                    }

                }
            }



    }

    public static void main(String[] args) {
        SynchronizedThread run =  new SynchronizedThread();
        Thread thread = new Thread(run);
        Thread thread1 = new Thread(run);

        thread.start();
        thread1.start();


    }
}
