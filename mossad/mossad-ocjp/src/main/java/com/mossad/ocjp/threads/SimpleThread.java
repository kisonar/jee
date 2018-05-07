package com.mossad.ocjp.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mmigdal on 2017-08-29.
 */
public class SimpleThread {

    public static void main(String[] args) {
        System.out.println("SimpleThread main program ....");

        //ExecutorService executor = Executors.newSingleThreadExecutor();

        /*
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello ###################### " + threadName);
        });

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        Future<Integer> future = executor.submit(task);
        Integer result = null;
        try {

            result = future.get(4, TimeUnit.SECONDS);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("result: " + result);
        */

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Callable<Integer> task1 = () -> {
            try {
                Thread.sleep(5000);
                
                return 11;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        Callable<Integer> task2 = () -> {
            try {
                Thread.sleep(1000);
                return 22;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        Callable<Integer> task3 = () -> {
            try {
                Thread.sleep(1000);
                return 33;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };


        //List<Callable<Integer>> callables = Arrays.asList(
        //        task1,task2, task3);

        //executor.
        
        /*
        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(futureBatch -> {
                        try {
                            return futureBatch.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*
        try {
             executor.invokeAll(callables).stream().map( futureBatchItem-> {
                 try {
                     return futureBatchItem.get();
                 } catch (InterruptedException | ExecutionException e) {
                     e.printStackTrace();
                     throw new IllegalStateException(e);
                 }
             }  ).forEach(System.out::println);
           // System.out.println("resultAsInteger is: "+resultAsInteger);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        //Shutting down executor -> if not done always waits for new threads :)

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }


        System.out.println("Done!");

    }

}
