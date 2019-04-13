package com.asispay.gaven.SimpleThread.security;

public class AtomicDemo{

    private static  int count=0;

    //原子性问题
    public static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(AtomicDemo::inc).start();
        }
        Thread.sleep(4000);
        System.out.println("y运行结果："+count);
        //y运行结果：997
        //y运行结果：996
        //y运行结果：1000
    }

}
