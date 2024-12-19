package org.example.deadlock_example;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void task() {
        if (lock1.tryLock()) {
            try {
                if (lock2.tryLock()) {
                    try {
                        System.out.println("Both locks acquired");
                    } finally {
                        lock2.unlock();
                    }
                }
            } finally {
                lock1.unlock();
            }
        }
    }
}
