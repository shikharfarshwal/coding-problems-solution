package multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Shikhar on 14-05-2019.
 */
public class ProducerConsumer {

    static BlockingQueue<Integer> integerBlockingQueue = new ArrayBlockingQueue<Integer>(8);


    public static void main(String[] args) {

        //producer
        final Runnable producer = () -> {

            while (true) {
                try {
                    integerBlockingQueue.put(createItem());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final Runnable consumer = () -> {
            while (true) {
                try {
                    process(integerBlockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static Integer createItem() {
        Random random = new Random();
        return random.nextInt();
    }

    private static void process(Integer i) {
        System.out.println("Element taken from queue is [ " + i + " ]");
    }
}
