package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountDownLatchExample {


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new DependentTasks(countDownLatch));
        executorService.execute(new DependentTasks(countDownLatch));
        executorService.execute(new DependentTasks(countDownLatch));

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The main thread will now start working");
    }

    static class DependentTasks implements Runnable {

        CountDownLatch countDownLatch;

        DependentTasks(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            countDownLatch.countDown();
            System.out.println("I [ " + Thread.currentThread().getName() + " ] have done count down and now i'm performing my operation");
        }
    }
}

