package com.shu.zyx.executor;

import javafx.concurrent.Task;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zyx on 2018/5/22.
 * Executors.newCachedThreadPool采用的阻塞队列为SynchronousQueue
 */
public class CachedThreadPool {
    public static void main(String[] args){


    }
    public void submitTask(Task task){
       ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        pool.setCorePoolSize(10);
        pool.setKeepAliveTime(10L,TimeUnit.MINUTES);
        pool.setMaximumPoolSize(100);
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
       Future result = pool.submit(task);

    }
}
