package com.old.code.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Suppose in a game you have to send a special message to each and every player who are participating without any discrimination of any player rece
 * receiving the message early on or later ; What can be done is you create a barrier and at this barrier the threads will wait until all threads
 * have reached this barrier .
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        ExecutorService executors = Executors.newFixedThreadPool(4);
        executors.submit(new Task(cyclicBarrier));
        executors.submit(new Task(cyclicBarrier));
        executors.submit(new Task(cyclicBarrier));
        executors.submit(new Task(cyclicBarrier));
        System.out.println("The main thread has nothing to do now");
    }

    public static class Task implements Runnable {

        CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("The thread [ " + Thread.currentThread().getName() + " ] have send the special message " +
                        "to the player");
                break;
            }
        }
    }
}


