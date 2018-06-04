package com.shu.zyx.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2018/6/4.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT=30;
    private static ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore=new Semaphore(10);
    public static void main(String[] args){
        for(int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        Thread.sleep(2000);
                        System.out.println("save data");
                    } catch (InterruptedException e) {

                    }
                    semaphore.release();

                }
            });
        }
        threadPool.shutdown();

    }
}
