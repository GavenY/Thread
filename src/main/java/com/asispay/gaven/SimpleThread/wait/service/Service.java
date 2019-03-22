package com.asispay.gaven.SimpleThread.wait.service;

/**
 * // wait() 会把当前的锁释放，然后让出CPU，进入等待状态  和
 * notify()/notifyAll()唤醒一个处于等待该 对象锁 的线程 并在跳出synchronized方法块时释放锁(lock.wait()跟lock.notify()，不是同一个对象锁，那么执行wait()那个线程会一直等待下去，
 * 或者调用wait（5000）时设置超时时间可以自动唤醒，两个方法顺序反了也会导致线程一直等待)
 * wait() and notify()  执行这两个方法必须要获得锁，要不然会报IllegalMonitorStateException
 *
 */
public class Service {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() ThreadName="
                        + Thread.currentThread().getName());
                lock.wait();
                System.out.println("  end wait() ThreadName="
                        + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("  end notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
