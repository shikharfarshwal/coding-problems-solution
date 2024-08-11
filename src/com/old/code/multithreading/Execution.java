package com.old.code.multithreading;

public class Execution implements Runnable {

    @Override
    public void run() {
        while (true) {

            // Here we are fetching the tasks from the
            // linkedblocking queue
            // which we have submitted using execute method
            // and executing them
            if (CustomThreadPool.linkedTaskBlockingQueue.size() != 0) {
                CustomThreadPool.linkedTaskBlockingQueue.poll().run();
            }
        }
    }
}
