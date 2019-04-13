package com.asispay.gaven.SimpleThread.callback;


import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo=new CallableDemo();
        Future<String> future =  executorService.submit(callableDemo);
        System.out.println(future.get());
        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        int a=1;
        int b=2;

        return "执行结果:"+(a+b);
    }
}
