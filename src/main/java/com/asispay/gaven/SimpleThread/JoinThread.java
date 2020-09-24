package com.asispay.gaven.SimpleThread;

public class JoinThread extends  Thread {

    public JoinThread(String name){
        super(name);
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("I am a\t" + getName());
            // 使用父类Thread里面定义的
            //public final String getName()，Returns this thread's name.
            try {
                sleep(1000);// 让子线程每执行一次就睡眠1秒钟
            } catch (InterruptedException e) {
                return;
            }
        }

    }

    public static void main(String[] args){

        JoinThread joinThread = new JoinThread("thread1");
        JoinThread joinThread2 = new JoinThread("thread2");
        joinThread2.start();
        joinThread.start();

        try {
            joinThread.join();// 调用join()方法合并线程，将子线程thread1合并到主线程里面,,实际上是调用了wati(),(主线程？)释放锁
            // 合并线程后，程序的执行的过程就相当于是方法的调用的执行过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("I am a\t" + "mainThread");
            // 使用父类Thread里面定义的
            //public final String getName()，Returns this thread's name.

        }

    }
}
