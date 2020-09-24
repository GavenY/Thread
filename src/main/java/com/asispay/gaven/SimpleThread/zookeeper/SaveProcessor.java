package com.asispay.gaven.SimpleThread.zookeeper;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Autheor:YJW
 * @Description:
 * @Time: Created in 2020/9/16:17:49
 * @Motified by:
 */
public class SaveProcessor extends Thread implements  RequestProcessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();


    @Override
    public void run() {
        while (true){
            try {
                Request request =  requests.take();
                System.out.println("Save Name : " + request.getName());
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
