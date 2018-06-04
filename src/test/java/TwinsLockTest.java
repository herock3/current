import com.shu.zyx.lock.TwinsLock;
import org.junit.Test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/5/29.
 */
public class TwinsLockTest {

    class Worker implements Runnable {
        private Lock lock;

        Worker(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            while (true) {
                lock.lock();
                try {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    @Test
    public void test() throws InterruptedException {
        Lock lock = new TwinsLock();
        for (int i = 1; i < 10; i++) {
            Thread thread = new Thread(new Worker(lock));
            thread.setDaemon(true);
            thread.start();
        }
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println("*******************");
        }

    }
    public static void main(String[] args){
        System.out.println("***********");
    }
}
