package com.shu.zyx.tools;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/6/4.
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch=new CountDownLatch(2);
    public static void main(String[] args){
        new Thread(new Runnable() {
            public void run() {
                System.out.println(1.1);
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println(2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);

    }
}
