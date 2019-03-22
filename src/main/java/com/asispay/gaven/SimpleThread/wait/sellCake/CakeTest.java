package com.asispay.gaven.SimpleThread.wait.sellCake;

public class CakeTest {


    public static void main(String[] args) {


        Object lock = new Object();
        Object lock2 = new Object();

        CakeHome cakeHome = new CakeHome(lock);
        cakeHome.start();

        SalesCake salesCake = new SalesCake(lock);
        salesCake.start();

    }
}
