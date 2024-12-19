package org.example;

import org.example.deadlock_example.DeadlockExample;
import org.example.producer_consumer.SharedResource;
import org.example.thread_synchronized.Counter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {

//        Counter counter = new Counter();
//
//        Thread thread1 = new Thread(counter::increment);
//        Thread thread2 = new Thread(counter::increment);
//        Thread thread3 = new Thread(counter::increment);
//        Thread thread4 = new Thread(counter::increment);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread1.join();
//        thread2.join();
//        thread3.join();
//        thread4.join();
//        System.out.println(counter.getCount());


        //2
//        SharedResource sharedResource = new SharedResource();
//
//        new Thread(() -> sharedResource.produce(100)).start();
//        new Thread(sharedResource::consume).start();


        //...
        DeadlockExample deadlockExample = new DeadlockExample();
        deadlockExample.task();


        //Also write totally Ramin's Main class code(his approach)
        //generate class tasks, can send info through ByteGo and can create images with Excalidraw
    }
}
