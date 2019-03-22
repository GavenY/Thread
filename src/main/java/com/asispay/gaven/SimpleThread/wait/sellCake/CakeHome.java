package com.asispay.gaven.SimpleThread.wait.sellCake;

public class CakeHome  extends Thread{

    private Object lock;

    private boolean flag = true;

    public CakeHome(Object lock) {
        super();
        this.lock = lock;

    }

    @Override
    public void run() {

        createCake();

    }


    private   void createCake(){

        synchronized(lock){
            try {
                System.out.println("制造蛋糕");

                while (flag){

                    if(CakeStock.CURRENTNUM>=CakeStock.MAX){

                        System.out.println("到达最大库存量，停止生产，等待售出到库存最低值后，再开始制作");

                        //Saleslock.notify();
                        lock.wait();
                        lock.notify();

                    }


                    CakeStock.CURRENTNUM++;
                    System.out.println("蛋糕数量加1 现有"+CakeStock.CURRENTNUM);
                    sleep(500);

                }

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
