package org.example.java_practice_room.concurrency.createWay;

public class helloRunnable implements myRunnable{

    @Override
    public void run(){
        System.out.println("helloRunnable, 线程通过继承runnable接口启动了");
    }
}
