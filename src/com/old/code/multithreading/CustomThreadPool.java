package com.old.code.multithreading;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool implements CustomExecutorService{

    int capacity;
    int currentcapacity;
     static LinkedBlockingQueue<Runnable> linkedTaskBlockingQueue;


    public CustomThreadPool(int capacity) {
        this.capacity = capacity;
        currentcapacity = 0;
        linkedTaskBlockingQueue = new LinkedBlockingQueue<Runnable>();
    }

    @Override
    public void submit(Runnable r) {
        linkedTaskBlockingQueue.add(r);
    }
}
