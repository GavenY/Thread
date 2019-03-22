package com.asispay.gaven.SimpleThread;

public class SimpleThread implements Runnable{
    @Override
    public void run() {


        for(int i=0;i<10;i++){

            System.out.println(Thread.currentThread().getName() +i);
        }

    }



    public  static void main(String[] args) {
        Thread thread = new Thread(new SimpleThread());
        thread.start();


        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() +i);
        }
    }
}
