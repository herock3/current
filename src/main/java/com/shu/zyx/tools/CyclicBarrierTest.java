package com.shu.zyx.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2018/6/4.
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println(1);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        cyclicBarrier.await();
        System.out.println(2);
    }

}
