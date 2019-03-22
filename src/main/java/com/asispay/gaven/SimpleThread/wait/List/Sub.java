package com.asispay.gaven.SimpleThread.wait.List;

public class Sub {

    private Object lock;

    public Sub(Object lock) {
        this.lock = lock;
    }

    public void subNote(){
        try{
            synchronized(lock){

                //if(SingletonList.list.size()==0){
                while(SingletonList.list.size()==0){  //当wait等待条件放生变化时，程序逻辑会发生改变， 所以可以用while 循环验证
                    System.out.println("wait begin ThreadName="
                            + Thread.currentThread().getName());
                    lock.wait();


                    System.out.println("wait   end ThreadName="
                            + Thread.currentThread().getName());
                }


                SingletonList.list.remove(0);

                System.out.println("List size = "+ SingletonList.list.size());




            }

                SingletonList.list.remove(0);

                System.out.println("List size = "+ SingletonList.list.size());




        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
