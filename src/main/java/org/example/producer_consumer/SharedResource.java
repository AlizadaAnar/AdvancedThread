package org.example.producer_consumer;

public class SharedResource {

    private int value;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) { //true olarsa ichine girir
            try { wait(); } catch (InterruptedException e) {}
        }
        this.value = value;
        available = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() {
        while (!available) {
            try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println("Consumed: " + value);
        available = false;
        notify();
    }
}
