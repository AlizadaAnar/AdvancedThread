package org.example.deadlock_example.real_practice;

import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingSystem {
    private final ReentrantLock seatLock = new ReentrantLock();
    private final ReentrantLock paymentLock = new ReentrantLock();

    public void bookTicket() {
        if (seatLock.tryLock()) {
            try {
                if (paymentLock.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " successfully booked the ticket!");
                    } finally {
                        paymentLock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to lock payment, retrying...");
                }
            } finally {
                seatLock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to lock seat, retrying...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        Thread user1 = new Thread(bookingSystem::bookTicket);
        Thread user2 = new Thread(bookingSystem::bookTicket);

        user1.start();
        user2.start();

        user1.join();
        user2.join();
    }
}
