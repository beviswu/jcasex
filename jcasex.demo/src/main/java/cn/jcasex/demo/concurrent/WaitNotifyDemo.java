package cn.jcasex.demo.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo description:
 * 本Demo用于演示Object#wait()和Object#sleep()的协作效果
 *
 * Demo notes:
 * 1. wait和notify都是object上的方法，而且是native的。
 * 2. wait和notify的前掉是获取到obj上的锁之后，才能生效。
 * 3. obj.wait()方法执行之后，当前线程立刻释放对象的锁，并停止往下执行；而obj.notify()执行之后，只是起到通知作用，不会立刻释放对象的锁，必须等到当前同步块的代码执行完之后，才会释放锁。
 * 4. 当obj.notify()被调用时，它就会从等待队列中，随机挑选一个线程，并将其唤醒。但是这里的选择是随机的，是不公平的。如果以下代码多执行几次的话发现，当t2-1，t2-2,t2-3这三个线程执行的顺便是不一样的。
 * <pre>
 * 16:57:47.880 [T2-2] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-2 start
 * 16:57:47.880 [T2-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-1 start
 * 16:57:47.880 [T1-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T1-1 start
 * 16:57:47.884 [T2-2] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-2 get the lock of obj
 * 16:57:47.880 [T2-3] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-3 start
 * 16:57:47.884 [T2-2] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-2 obj.notifyAll() start
 * 16:57:47.884 [T2-2] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-2 obj.notifyAll() end
 * 16:57:47.884 [T2-3] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-3 get the lock of obj
 * 16:57:47.884 [T2-2] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-2 end
 * 16:57:47.884 [T2-3] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-3 obj.notifyAll() start
 * 16:57:47.884 [T2-3] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-3 obj.notifyAll() end
 * 16:57:47.884 [T2-3] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-3 end
 * 16:57:47.884 [T1-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T1-1 get the lock of obj
 * 16:57:47.884 [T1-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T1-1 sleep(5s) start
 * 16:57:52.939 [T1-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T1-1 sleep(5s) end, obj.wait() start
 * 16:57:52.939 [T2-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-1 get the lock of obj
 * 16:57:52.939 [T2-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-1 obj.notifyAll() start
 * 16:57:52.939 [T2-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-1 obj.notifyAll() end
 * 16:57:52.940 [T2-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T2-1 end
 * 16:57:52.940 [T1-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T1-1 obj.wait() end
 * 16:57:52.940 [T1-1] INFO cn.jcasex.demo.concurrent.WaitNotifyDemo - T1-1 end
 * </pre>
 **/

public class WaitNotifyDemo {

    private static final Logger logger = LoggerFactory.getLogger(WaitNotifyDemo.class);

    private final static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info(Thread.currentThread().getName() + " start");
                synchronized (obj) {
                    logger.info(Thread.currentThread().getName() + " get the lock of obj");

                    try {
                        logger.info(Thread.currentThread().getName() + " sleep(5s) start");
                        Thread.sleep(5000);

                        logger.info(Thread.currentThread().getName() + " sleep(5s) end, obj.wait() start");

                        // obj.wait执行之后，立刻释放锁，不再往下继续执行
                        obj.wait();

                        //当重新获得锁之后，还会继续往下执行。
                        logger.info(Thread.currentThread().getName() + " obj.wait() end");
                        logger.info(Thread.currentThread().getName() + " end");
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        }, "T1-1");
        thread1.start();

        //logger.info(Thread.currentThread().getName() + " sleep(1s) start");
        //Thread.sleep(4000);
        //logger.info(Thread.currentThread().getName() + " sleep(1s) end");

        Thread thread2 = null;
        for (int i = 1; i <= 3; i++) {
            thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    logger.info(Thread.currentThread().getName() + " start");
                    synchronized (obj) {
                        logger.info(Thread.currentThread().getName() + " get the lock of obj");

                        logger.info(Thread.currentThread().getName() + " obj.notifyAll() start");
                        // obj.notify（）调用之后，不会立即释放obj对象的锁，只是起到通知作用。必须等到synchronized (obj){}同步块的内容执行完了，才会释放锁。
                        obj.notifyAll();

                        logger.info(Thread.currentThread().getName() + " obj.notifyAll() end");
                    }
                    logger.info(Thread.currentThread().getName() + " end");
                }
            }, "T2-" + String.valueOf(i));
            thread2.start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }
}

