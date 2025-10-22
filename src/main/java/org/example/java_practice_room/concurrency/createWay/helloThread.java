package org.example.java_practice_room.concurrency.createWay;

/**
 *  使用继承Thread类的方式创建线程
 *  1. 创建一个继承Thread类的子类
 *  2. 创建了不代表运行，需要创建对应的实例，调用start()方法启动
 */
public class helloThread extends Thread {

    @Override
    public void run() {

        System.out.println("helloThread, 线程通过继承Thread类启动了");
//
//        System.out.println("线程id是 " + getId() + "," + "线程名字是 " + getName() + "," + "当前线程是 " + Thread.currentThread());
//
//        System.out.println("线程获取优先级的方法是 " + getPriority() + " 设置优先级方法是 setPriority" + "优先级一般是1到10" );
//
//        System.out.println("线程状态分别是" + "new（未被调用的线程）" + "runable（未被阻塞的线程，包括等待和执行状态）" + "blocked（线程阻塞）" + "waiting（线程阻塞）" + "timeWaiting（线程阻塞）" + "terminate（线程运行结束）");
//
//        System.out.println("测试线程是否还存在的方法是 " + isAlive() + " 这个方法在run方法运行结束前都是true");
//
//        System.out.println("测试线程是否是垃圾回收进程方法 " + isDaemon() + " 这个进程代表了多线程里的垃圾回收机制");
//
//        System.out.println("中止线程运行方法有 " + "join yield sleep");

    }

}
