package com.shu.zyx.method;

/**
 * Created by Administrator on 2018/5/3.
 */
public class DeadLock {
    public static void main(String[] args){
        Beauty beauty=new Beauty();
        Country country=new Country();
        Thread t1=new Thread(new Lock1(beauty,country));
        Thread t2=new Thread(new Lock2(beauty,country));
        t1.start();
        t2.start();
    }

    static class Lock1 implements Runnable{
        private  Beauty beauty;
        private  Country country;
        Lock1(Beauty beauty,Country country){
            this.beauty=beauty;
            this.country=country;
        }
        public void run() {
            while(true){
                try {
                    synchronized (country){
                        country.country();
                        synchronized (beauty){
                            beauty.beauty();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Lock2 implements Runnable{
        private  Beauty beauty;
        private  Country country;
        Lock2(Beauty beauty,Country country){
            this.beauty=beauty;
            this.country=country;
        }
        public void run() {
            while(true){
                try {
                  synchronized (beauty){
                      beauty.beauty();
                      synchronized (country){  //作用美人却想江山
                          country.country();
                      }
                  }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Beauty{

        public  void beauty() throws InterruptedException {
            System.out.println(Thread.currentThread().getName()+"-->beauty");

        }
    }
    static class Country{

        public  void country() throws InterruptedException {
            System.out.println(Thread.currentThread().getName()+"-->country");
        }

    }

}
