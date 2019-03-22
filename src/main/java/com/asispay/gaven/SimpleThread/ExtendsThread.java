package com.asispay.gaven.SimpleThread;

public class ExtendsThread extends Thread {



    @Override
    public void run() {

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() +i);
        }
    }

    public static void main(String[] args) {


        ExtendsThread thread = new ExtendsThread();
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() +i);
        }

    }
}
