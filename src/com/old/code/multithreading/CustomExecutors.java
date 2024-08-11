package com.old.code.multithreading;

public class CustomExecutors {


    CustomExecutorService newFixedThreadPool(int thread){
        return new CustomThreadPool(thread);
    }
}
