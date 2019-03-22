package com.asispay.gaven.SimpleThread.samelock;


public class SyncThread {

    //测试synchronized作用域
    public static void main(String[] args) {

        Service service = new Service();

        SyncThread syncThread = new SyncThread();

        MyThread myThread = syncThread.new MyThread(service);
        myThread.start();

        MyThread2 myThread2 = syncThread.new MyThread2(service);
        myThread2.start();

    }

    class MyThread extends  Thread{

        private Service service;

        public MyThread(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.mothod1();
        }
    }

    class MyThread2 extends  Thread{

        private Service service;

        public MyThread2(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            //service.mothod1();
            service.mothod2();
        }
    }

}
