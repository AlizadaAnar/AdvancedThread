package org.example.thread_synchronized.real_practice;


class BankAccount {
    private int balance = 1000; // Starting balance

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class BankApp {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread customer1 = new Thread(() -> account.withdraw(300));
        Thread customer2 = new Thread(() -> account.withdraw(500));
        Thread customer3 = new Thread(() -> account.withdraw(200));
        Thread customer4 = new Thread(() -> account.withdraw(100));

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();

        customer1.join();
        customer2.join();
        customer3.join();
        customer4.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}
