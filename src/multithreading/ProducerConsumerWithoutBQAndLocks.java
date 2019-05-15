package multithreading;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shikhar on 14-05-2019.
 */
public class ProducerConsumerWithoutBQAndLocks {

    public class MyBlockingQueue<T> {
        private Queue<T> queue;
        private int maxSize = 16;

        public MyBlockingQueue(int size) {
            this.queue = new LinkedList<>();
            this.maxSize = size;
        }

        public void put(T element) throws InterruptedException {
            while (true) {
                synchronized (this) {
                    if (this.queue.size() == maxSize) {
                        //block the thread; //release the lock temporarily
                        wait();
                    }
                    queue.add(element);
                    queue.notify();
                    Thread.sleep(1000);
                }
            }
        }


        public T take() throws InterruptedException {
            while (true) {
                synchronized (this) {

                    while (this.queue.size() == 0) {
                        wait(); //release the lock temporarily
                    }
                    T remove = queue.remove();
                    notifyAll();
                    return remove;
                }
            }
        }
    }
}


