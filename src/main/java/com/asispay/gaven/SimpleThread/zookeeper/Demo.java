package com.asispay.gaven.SimpleThread.zookeeper;

/**
 * @Autheor:YJW
 * @Description:
 * @Time: Created in 2020/9/16:19:01
 * @Motified by:
 */
public class Demo {

    PrintProcessor printProcessor;

    public Demo() {
        SaveProcessor processor  = new SaveProcessor();
        processor.start();
        printProcessor = new PrintProcessor(processor);
        printProcessor.start();
    }

    public static void main(String[] args){

        Request request = new Request();
        request.setName("zookeeper 调用链");

       new Demo().setTest(request);



    }

    private void setTest(Request request) {
        printProcessor.processRequest(request);
    }
}
