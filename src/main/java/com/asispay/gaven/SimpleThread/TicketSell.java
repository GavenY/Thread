package com.asispay.gaven.SimpleThread;

public class TicketSell  implements Runnable{

    volatile int  ticket = 50;

    @Override
    public   void  run() {

        System.out.println(Thread.currentThread().getName()+"开始售票");

            while(true){
                synchronized (this){
                ticket--;
                }
                System.out.println(Thread.currentThread().getName()+"售出一张票，还剩"+ticket);

                if(ticket==0 || ticket<0){
                    break;
                }
        }


    }

    public static void main(String[] args) {

        TicketSell ticketSell = new TicketSell();
        Thread thread1 = new Thread(ticketSell);
        thread1.setName("窗口A");
        Thread thread2 = new Thread(ticketSell);
        thread2.setName("窗口B");




        thread1.start();
        thread2.start();

    }
}
