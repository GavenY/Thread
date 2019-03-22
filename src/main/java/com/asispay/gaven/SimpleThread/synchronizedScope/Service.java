package com.asispay.gaven.SimpleThread.synchronizedScope;

public class Service {

    public synchronized void mothod1(){

        while(true){

            System.out.println("同步方法执行中");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public  void mothod2(){

        while(true){

            System.out.println("非同步方法可以执行");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
