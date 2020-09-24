package com.asispay.gaven.SimpleThread.zookeeper;

/**
 * @Autheor:YJW
 * @Description:
 * @Time: Created in 2020/9/16:17:48
 * @Motified by:
 */
public interface RequestProcessor {

    void processRequest(Request request);

}
