package com.asispay.gaven.SimpleThread.request;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcessor extends  Thread implements RequestProcessor{

    //put方法在队列满的时候会阻塞直到有队列成员被消费，take方法在队列空的时候会阻塞，直到有队列成员被放进来。
    LinkedBlockingQueue<Request> linkedBlockingQueue=new LinkedBlockingQueue();

    private final  RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while(true){
            try {
                Request request=linkedBlockingQueue.take();
                System.out.println("print data:"+request);
                nextProcessor.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
