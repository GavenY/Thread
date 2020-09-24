package com.asispay.gaven.SimpleThread;

public class YieldThread extends  Thread{


    YieldThread(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + "：" + i);
            if (i % 2 == 0) {
                yield();// 当执行到i能被2整除时当前执行的线程就从运行状态（Runging）转为就绪状态(Runable)，等待cpu调度，有可能直接调度到原来线程,不会让出锁
            }
        }
    }

    public static void main(String args[]) {
        YieldThread t1 = new YieldThread("t1");
        /* 同时开辟了两条子线程t1和t2，t1和t2执行的都是run()方法 */
        /* 这个程序的执行过程中总共有3个线程在并行执行，分别为子线程t1和t2以及主线程 */
        YieldThread t2 = new YieldThread("t2");
        t1.start();// 启动子线程t1
        t2.start();// 启动子线程t2
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }
}


