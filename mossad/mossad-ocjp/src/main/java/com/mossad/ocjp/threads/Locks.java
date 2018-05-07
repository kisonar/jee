package com.mossad.ocjp.threads;

import com.mossad.ocjp.threads.pojo.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by mmigdal on 2017-08-29.
 */
public class Locks {


    public static void main(String[] args) {
        System.out.println("SimpleThread main program ....");

        Counter counter = new Counter();

        ExecutorService executor = Executors.newFixedThreadPool(20);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(counter::increment));




        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);

            System.out.println("result is: " +counter.getResult());

        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }


    }
}
