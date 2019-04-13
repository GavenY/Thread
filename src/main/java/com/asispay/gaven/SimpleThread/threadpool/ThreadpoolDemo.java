package com.asispay.gaven.SimpleThread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolDemo {

    private static volatile  boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        //Executors.newCachedThreadPool(); 创建缓存线程池，即线程池大小为0，直接进入线程缓存队列，



//        private final BlockingQueue<Runnable> workQueue;              //任务缓存队列，用来存放等待执行的任务
//        private final ReentrantLock mainLock = new ReentrantLock();   //线程池的主要状态锁，对线程池状态（比如线程池大小
//        //、runState等）的改变都要使用这个锁
//        private final HashSet<Worker> workers = new HashSet<Worker>();  //用来存放工作集
//
//        private volatile long  keepAliveTime;    //线程存货时间
//        private volatile boolean allowCoreThreadTimeOut;   //是否允许为核心线程设置存活时间
//        private volatile int   corePoolSize;     //核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
//        private volatile int   maximumPoolSize;   //线程池最大能容忍的线程数 ，到达时启动拒绝策略
//
//        private volatile int   poolSize;       //线程池中当前的线程数
//
//        private volatile RejectedExecutionHandler handler; //任务拒绝策略
//
//        private volatile ThreadFactory threadFactory;   //线程工厂，用来创建线程
//
//        private int largestPoolSize;   //用来记录线程池中曾经出现过的最大线程数
//
//        private long completedTaskCount;   //用来记录已经执行完毕的任务个数

/*
        如果当前线程池中的线程数目小于corePoolSize，则每来一个任务，就会创建一个线程去执行这个任务；
        如果当前线程池中的线程数目>=corePoolSize，则每来一个任务，会尝试将其添加到任务缓存队列当中，若添加成功，则该任务会等待空闲线程将其取出去执行；若添加失败（一般来说是任务缓存队列已满），则会尝试创建新的线程去执行这个任务；
        如果当前线程池中的线程数目达到maximumPoolSize，则会采取任务拒绝策略进行处理；
        如果线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止，直至线程池中的线程数目不大于corePoolSize；如果允许为核心池中的线程设置存活时间，那么核心池中的线程空闲时间超过keepAliveTime，线程也会被终止。*/

        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        poolExecutor.execute(()->{
            while(flag){
                System.out.println("Thread Pool");
            }
        });

        TimeUnit.SECONDS.sleep(1);
        flag=false;
        poolExecutor.shutdown();
    }

}
