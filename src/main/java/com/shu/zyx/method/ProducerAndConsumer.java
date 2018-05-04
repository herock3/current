package com.shu.zyx.method;

/**
 * Created by Administrator on 2018/5/3.
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();

    }
    static class Resource{
        private int num;
        private int size=10;
        public synchronized void add() throws InterruptedException {
            if(num<size){
                num++;
                System.out.println(Thread.currentThread().getName()+"线程生产一件+线程池还有"+num+"件");
                this.notifyAll();
                System.out.println("**************测试中**************");
            }else{
                this.wait();
            }
        }
        public synchronized void remove() throws InterruptedException {
            if(num>0){
                num--;
                System.out.println(Thread.currentThread().getName()+"线程消费一件+线程池还有"+num+"件");
                this.notifyAll();
            }else{
                this.wait();
            }
        }

    }
    static class Producer implements Runnable{
        private Resource resource;
        Producer(Resource resource){
            this.resource=resource;
        }
        public void run() {
            while(true){
                try {
                    resource.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    static class Consumer implements Runnable{
        private Resource resource;
        Consumer(Resource resource){
            this.resource=resource;
        }
        public void run() {
            while(true){
                try {
                    resource.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
