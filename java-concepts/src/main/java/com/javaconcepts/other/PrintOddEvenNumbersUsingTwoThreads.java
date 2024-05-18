package com.javaconcepts.other;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PrintOddEvenNumbersUsingTwoThreads {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10).forEach(i -> {
            CompletableFuture<Void> even = CompletableFuture.runAsync(() -> {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " prints " + i);
                }
            }, executorService);
            even.join();

            CompletableFuture<Void> odd = CompletableFuture.runAsync(() -> {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " prints " + i);
                }
            }, executorService);
            odd.join();
        });

        executorService.shutdown();
    }
}
