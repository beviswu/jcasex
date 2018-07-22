package cn.jcasex.demo.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 1. wait和notify都是object上的方法，而且是native的。
 * 2. wait和notify的前掉是获取到obj上的锁之后，才能生效。
 * 3. obj.wait()方法执行之后，当前线程立刻释放对象的锁，并停止往下执行；而obj.notify()执行之后，只是起到通知作用，不会立刻释放对象的锁，必须等到当前同步块的代码执行完之后，才会释放锁。
 * 4. 当obj.notify()被调用时，它就会从等待队列中，随机挑选一个线程，并将其唤醒。但是这里的选择是随机的，是不公平的。如果以下代码多执行几次的话发现，当t2-1，t2-2,t2-3这三个线程执行的顺便是不一样的。
 */
public class WaitNotifyDemo {

    private static final Logger logger = LoggerFactory.getLogger(WaitNotifyDemo.class);


    private final static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1("1");
        t1.start();

        Thread.sleep(1000);

        Thread t2 = null;
        for(int i=1;i<=3;i++){
            t2 = new T2(String.valueOf(i));
            t2.start();
        }

    }


    public static class T1 extends Thread {

        public T1(String threadName) {
            this.setName("T1-" + threadName);
        }

        @Override
        public void run() {
            logger.info(this.getName() + " started");

            synchronized (obj) {
                logger.info(this.getName() + " get the lock of obj");

                try {
                    Thread.sleep(2000);

                    logger.info(this.getName() + " before  waited");

                    // obj.wait执行之后，立刻释放锁，不再往下继续执行
                    obj.wait();

                    //当重新获得锁之后，还会继续往下执行。
                    logger.info(this.getName()+" after waited");

                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            logger.info(this.getName() + " ended");
        }
    }

    public static class T2 extends Thread {

        public T2(String threadName) {
            this.setName("T2-" + threadName);
        }

        @Override
        public void run() {
            logger.info(this.getName() + " started");


            synchronized (obj) {
                logger.info(this.getName() + " get the lock of obj");

                logger.info(this.getName() + " before execute obj.notify()");

                // obj.notify（）调用之后，不会立即释放obj对象的锁，只是起到通知作用。必须等到synchronized (obj){}同步块的内容执行完了，才会释放锁。
                obj.notifyAll();

                logger.info(this.getName() + " after execute obj.notify()");

            }
            logger.info(this.getName() + " ended");
        }
    }

}

