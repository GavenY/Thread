package com.asispay.gaven.SimpleThread.zookeeper;

/**
 * @Autheor:YJW
 * @Description:  模仿zookeeper  服务异步调用
 * @Time: Created in 2020/9/16:17:46
 * @Motified by:
 */
public class Request {

    private  String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
