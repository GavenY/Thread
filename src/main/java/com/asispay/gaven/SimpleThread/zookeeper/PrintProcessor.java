package com.asispay.gaven.SimpleThread.zookeeper;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Autheor:YJW
 * @Description:
 * @Time: Created in 2020/9/16:17:49
 * @Motified by:
 */
public class PrintProcessor extends Thread implements  RequestProcessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private  final  RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while (true){
            try {
                Request request =  requests.take();
                System.out.println("Print Name : " + request.getName());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //添加处理请求
    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
