package com.asispay.gaven.SimpleThread.wait.sellCake;

public class SalesCake extends  Thread {


    private Object lock;
    private boolean flag = true;

    public SalesCake(Object lock) {
        super();
        this.lock = lock;

    }

    @Override
    public void run() {

        salesCake();

    }

    private   void salesCake() {
        synchronized(lock){

            System.out.println("开始销售蛋糕");

            try{

                while (flag){

                    if(CakeStock.CURRENTNUM<=CakeStock.MIN){



                        System.out.println("到达最小库存量，停止售出，等待高于库存最低值后，再开始售出");

                        lock.notify();
                        lock.wait();
                        //Saleslock.wait(); 对象锁不同会报错
                    }


                    CakeStock.CURRENTNUM--;
                    System.out.println("蛋糕数量减1 剩余"+ CakeStock.CURRENTNUM);
                    sleep(1000);

                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }

}
