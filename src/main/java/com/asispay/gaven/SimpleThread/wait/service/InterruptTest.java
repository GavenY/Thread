package com.asispay.gaven.SimpleThread.wait.service;

public class InterruptTest {

    public static void main(String[] args) {

        Object lock = new Object();

        WaitThread a = new WaitThread(lock);
        a.start();

        //如果不唤起等待线程 ，它会一直阻塞，  除了可以notify()/notifyAll() 之外可以用interrupt() 打断线程报出异常，直接结束
        try {
            Thread.currentThread().sleep(3000);
            a.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * ⑤多线程中测试某个条件的变化用 if 还是用 while？
     *
     * 以前一直不明白 当在线程的run()方法中需要测试某个条件时，为什么用while，而不用if?
     *
     * 这个例子是这样的：
     *
     * 有两个线程从List中删除数据，而只有一个线程向List中添加数据。初始时，List为空，只有往List中添加了数据之后，才能删除List中的数据。添加数据的线程向List添加完数据后，调用notifyAll()，唤醒了两个删除线程，但是它只添加了一个数据，而现在有两个唤醒的删除线程，这时怎么办？?
     */
}
