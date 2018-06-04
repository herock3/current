package com.shu.zyx.tools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/6/4.
 */
public class ExchangerTest {
    private static Exchanger<String> exchanger=new Exchanger <String>();
    private static ExecutorService threadPool= Executors.newFixedThreadPool(2);
    public static void main(String[] args){
        threadPool.execute(new Runnable() {
            public void run() {
                String A="测试A";
                try {
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            public void run() {
                String B="测试B";
                try {
                    String A=exchanger.exchange(B);
                    System.out.println("A和B数据是否一致:"+A.equals(B)+" "+"A为:"+A+" "+"B为:"+B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
