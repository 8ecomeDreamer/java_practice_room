package org.example.java_practice_room.concurrency;

import org.example.java_practice_room.concurrency.createWay.helloRunnable;
import org.example.java_practice_room.concurrency.createWay.helloThread;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class threadApplication {

    public static void runThread() {
        helloThread myThread = new helloThread();
        myThread.start();
    }

    public static void runRunnable() {
        helloRunnable helloRunnable = new helloRunnable();
        helloRunnable.run();
    }

    private static int shared = 0;
    private static void incrShared() {
        shared++;
    }

    static class ChildThread extends Thread {
        List<String> list;

        public ChildThread(List<String> list) {
            this.list = list;
        }


        @Override
        public void run () {
            incrShared();
            list.add(Thread.currentThread().getName());
        }
    }

    public static void learnBasicProperity() {

        Thread thread = new Thread();

        System.out.println("获取线程的id和名称 " + thread.getId() + " " + thread.getName());
        System.out.println("获取线程的优先级 " + thread.getPriority());
        thread.setPriority(10);
        System.out.println("默认优先级为5，现在设置为10 " + thread);
        System.out.println("获取线程各种状态" + thread.getState() + " 其中new是线程创建完成和等待状态，terminate是线程结束，block代表线程阻塞");
        System.out.println("判断线程是否存活" + thread.isAlive());
        System.out.println("判断线程是否为daemon线程，该线程相当于多线程中的垃圾回收线程，当仅剩这个进程后，系统会进行垃圾回收" + thread.isDaemon());
        System.out.println("中断线程的方法 " + "有 join sleep yield等方法");
    }


    public static void main(String[] args) throws InterruptedException {

        runThread();
        runRunnable();

        System.out.println("----------- 多线程共享内存demo ------------" );
        List<String> list = new ArrayList<String>();
        Thread t1 = new ChildThread(list);
        Thread t2 = new ChildThread(list);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("内存值" + shared);
        System.out.println("最后存储的线程名称" + list);
        System.out.println("----------- 多线程共享内存demo ------------" );

        learnBasicProperity();
    }
}
