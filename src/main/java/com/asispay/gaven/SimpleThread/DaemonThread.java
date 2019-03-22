package com.asispay.gaven.SimpleThread;

public class DaemonThread {


    class MyThread extends Thread{

        private  boolean  flag = true;

        public void setStop(){

            this.flag = false;
        }

        @Override
        public void run() {

            while (flag){
                System.out.println(getName()+ " Runing");
            }

        }
    }


    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+" main线程睡眠");
        DaemonThread daemonThread = new DaemonThread();

        MyThread myThread =  daemonThread.new MyThread();

        myThread.setDaemon(true); //主线程结束守护线程也一起结束，默认为false，线程完成自己的Run（）运行体时结束dead
        myThread.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" main线程结束");
    }
}
