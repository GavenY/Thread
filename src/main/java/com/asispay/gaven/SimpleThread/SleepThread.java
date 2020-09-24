package com.asispay.gaven.SimpleThread;

import java.util.Date;

public class SleepThread extends  Thread {

    boolean flag = true;

    Object object;

    public SleepThread setLock(Object o){
        this.object = o;
        return this;
    }

    public void setStop(){
        this.flag = false;
    }

    @Override
    public void run() {


        synchronized(object){
            while(flag){
                System.out.println(getName() +" ==========" + new Date().toLocaleString() + "===========");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    return;
                }
            }
        }


    }

    public static void main(String[] args){

        Object o = new Object();
        SleepThread sleepThread = new SleepThread().setLock(o);
        sleepThread.setName("线程一");

        SleepThread sleepThread2 = new SleepThread().setLock(o);// 同一个对象o不会释放锁
        sleepThread2.setName("线程二");
        sleepThread.start();
        sleepThread2.start();

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            return;
        }

        //sleepThread.flag = false; //修改全局控制变量  建议
        sleepThread.interrupt(); //打断当前线程,抛出InterrupteException 不建议使用interrupt打断线程运行状态，使用全局变量控制，直接打断只能打断阻塞状态不能打断运行状态的线程
        //如果是Runing线程可以用  if(!sleepThread.isInterrupted()) 当作判断条件，当线程调用interrupt是返回true

    }
}
