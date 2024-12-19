package org.example.callabla_example.real_practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileDownloadExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> downloadTask = () -> {
            System.out.println("Starting file download...");
            Thread.sleep(3000);
            return "Download Complete!";
        };

        Future<String> future = executor.submit(downloadTask);

        System.out.println("File is downloading in the background...");

        System.out.println("Result: " + future.get());
        executor.shutdown();
    }
}
