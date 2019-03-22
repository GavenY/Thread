# Java线程总结

##定义
cpu调度的最小单位

##线程状态

<table>
  <tr>
	<th>状态</th>
	<th>事件</th>
	
  </tr>
	<tr>
		<td>创建(new)</td>
		<td>new</td>
		
		
	  </tr>
	<tr>
		<td>就绪(Runable)</td>
		<td>系统分配资源（划分堆、栈空间等）、时间片用完时、IO阻塞结束时、sleep（）失眠时间结束时、notify（）唤醒时</td>
		
	  </tr>
<tr>
		<td>运行(Runing)</td>
		<td>获取cpu时间片</td>
		
	  </tr>
<tr>
		<td>阻塞(block)</td>
		<td>IO操作，jion（）、wait（）、sleep（）、synchronized </td>
		
	  </tr>
<tr>
		<td>结束(dead)</td>
		<td>run()方法执行完成、daemon（true）守护线程的主线程结束时</td>
		
	  </tr>

</table>

##创建

1. 继承Thread类
2. 实现Runable接口

（```）

	public class SimpleThread implements Runnable{
    @Override
    public void run() {  //方法体


        for(int i=0;i<10;i++){

            System.out.println(Thread.currentThread().getName() +i);
        }

    }



    public static void main(String[] args) {

		//new SimpleThread().run();可以直接执行，但是是基于Main主线程方法下执行，不是多线程

		//需重新new Thread（）新的线程；
        Thread thread = new Thread(new SimpleThread());
        thread.start();


        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() +i);
        }
    }
}
 (```)


##同步锁

在多线程的情况下Thread1和Thread2第一次执行下面单例模式getInstance()方法，当Thread1执行到1行，Thread2执行到2行，Thread1判断还是为null继续运行下去，执行new A()，造成Thread1的实例覆盖Thread2的实例，破坏单例模式。

（```）

	  private A a;
      private A(){}
	  public A getInstance(){

        if(a==null){      //1 
           a = new A();  //2
	        return a    
		}
	   
	   return a;
	}
 (```)


为了保证公共资源的安全，让程序按照我们想法执行，我们得为公共资源加上锁，利用synchronized 关键字,可以加在方法前面，也可以加到方法块前面，建议后者，这样粒度小

(```)

	public class SleepThread extends  Thread {

    boolean flag = true;

    Object object;

    public SleepThread setLock(Object o){
        this.object = o;
        return this;
    }

    public void setStop(){
        this.flag = false;
    }

    @Override
    public void run() {


        synchronized(object){
            while(flag){
                System.out.println(getName() +" ==========" + new Date().toLocaleString() + "===========");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    return;
                }
            }
        }


    }

    public static void main(String[] args){

        Object o = new Object();
        SleepThread sleepThread = new SleepThread().setLock(o);
        sleepThread.setName("线程一");

        SleepThread sleepThread2 = new SleepThread().setLock(o);//不会释放锁   //.setLock("");
        sleepThread2.setName("线程二");
        sleepThread.start();
        sleepThread2.start();

        try {
            Thread.sleep(50000);
        }catch (InterruptedException e){
            return;
        }

        //sleepThread.flag = false; //修改全局控制变量  建议
        sleepThread.interrupt(); //打断当前线程,抛出InterrupteException 不建议使用interrupt打断线程运行状态，使用全局变量控制，直接打断只能打断阻塞状态不能打断运行状态的线程
        //如果是Runing线程可以用  if(!sleepThread.isInterrupted()) 当作判断条件，当线程调用interrupt是返回true

    }
}

(```)

`synchronized(object){ }` synchronized关键字获取object的锁，获取到了才能往下访问，多线程只是栈独立，堆共享，所以上面例子中当线程一先获得锁，线程一执行只能线程二等待；

（```)

    当获取锁对象是一致时
	线程一 ==========2019-3-22 18:00:20===========
	线程一 ==========2019-3-22 18:00:21===========
	线程一 ==========2019-3-22 18:00:22===========
	线程一 ==========2019-3-22 18:00:23===========
	线程一 ==========2019-3-22 18:00:24===========
	..........


 	当获取锁对象是不同的对象时
	线程二 ==========2019-3-22 18:08:31===========
	线程一 ==========2019-3-22 18:08:31===========
	线程一 ==========2019-3-22 18:08:32===========
	线程二 ==========2019-3-22 18:08:32===========
	线程一 ==========2019-3-22 18:08:33===========
	线程二 ==========2019-3-22 18:08:33===========
    .....
(```)

