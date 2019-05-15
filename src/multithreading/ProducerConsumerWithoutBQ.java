package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement BQ using Locks & conditions
 */
public class ProducerConsumerWithoutBQ {

    public class MyBlockingQueue<T> {

        ReentrantLock reentrantLock = new ReentrantLock(true);
        Condition notFull = reentrantLock.newCondition();
        Condition notEmpty = reentrantLock.newCondition();
        private Queue<T> queue;
        private int maxSize = 16;

        public MyBlockingQueue(int size) {
            this.queue = new LinkedList<>();
            this.maxSize = size;
        }

        public void put(T element) {
            reentrantLock.lock();
            try {
                if (this.queue.size() == maxSize) {
                    //block the thread; //release the lock temporarily
                    notFull.wait();
                }
                this.queue.add(element);
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }

        public T take() throws InterruptedException {
            reentrantLock.lock();
            try {
                while (this.queue.size() == 0) { // problem with if condition here is that if (this.queue.size() == 0)  suppose there
                    //are two threads t1 , t2 and both of them are in wait state then a producer thread comes along and produces an item
                    //the queue at that time boththese threads will come into runnable state and only one of them will acquire the lock(for ex t2)
                    //then t2 removes an item from the queue and release the lock However when t1 acquires the lock it will again try to remove the
                    //item from the queue and this will give it a NULL. To avoid this scenarion we used a while loop.
                    //block the thread
                    notEmpty.wait(); //release the lock temporarily
                }
                T remove = this.queue.remove();
                notFull.signalAll();
                return remove;
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
