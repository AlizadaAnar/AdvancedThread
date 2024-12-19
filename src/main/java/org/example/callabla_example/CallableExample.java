package org.example.callabla_example;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(500);
            return 42;
        };

        //without lambda
//        Callable<Integer> task = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                Thread.sleep(500); // Simulating some work
//                return 42; // Return the result
//            }
//        };

        Future<Integer> future = executor.submit(task);
        System.out.println("Result: " + future.get());
        executor.shutdown();
    }
}
