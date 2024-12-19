package org.example.thread_synchronized;

public class Counter {
    private int count = 0;

    //synchrinizing whole method
    public synchronized void increment() { // Only one thread can run this at a time
        count++;
    }

    //synchrinizing only specific line
//    public synchronized void increment() {
//        synchronized (this) {
//            count++;
//        }
//    }

    public int getCount() {
        return count;
    }
}
