package org.example.producer_consumer.real_practice;

class TicketBookingSystem {
    private int availableTickets = 5;

    public synchronized void bookTicket() {
        while (availableTickets == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for a ticket.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        availableTickets--;
        System.out.println(Thread.currentThread().getName() + " booked a ticket. Tickets left: " + availableTickets);
        notifyAll();
    }

    public synchronized void replenishTickets() {
        availableTickets = 5;
        System.out.println("Booking Agent replenished the tickets.");
        notifyAll();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketBookingSystem system = new TicketBookingSystem();

        Thread customer1 = new Thread(system::bookTicket, "Customer 1");
        Thread customer2 = new Thread(system::bookTicket, "Customer 2");
        Thread customer3 = new Thread(system::bookTicket, "Customer 3");
        Thread customer4 = new Thread(system::bookTicket, "Customer 4");
        Thread customer5 = new Thread(system::bookTicket, "Customer 5");
        Thread customer6 = new Thread(system::bookTicket, "Customer 6");

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
        customer6.start();

        Thread agent = new Thread(() -> {
            try {
                Thread.sleep(2000);
                system.replenishTickets();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        agent.start();

        customer1.join();
        customer2.join();
        customer3.join();
        customer4.join();
        customer5.join();
        customer6.join();
        agent.join();
    }
}
