package com.asispay.gaven.SimpleThread.samelock;

public class Service {

    Object object = new Object();

    public  void mothod1(){

        synchronized(object){
            while(true){

                System.out.println("同步方法执行中1");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }



    }


    public  void mothod2(){
        synchronized(""){
        //synchronized(object){
            while(true){

                System.out.println("同步方法执行中2");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
