package org.example.java_practice_room.concurrency.useSynchronized;

/**
 * 使用synChronized实现计算器
 */
public class Counter {

    private int count;
    public synchronized void incr() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

}
