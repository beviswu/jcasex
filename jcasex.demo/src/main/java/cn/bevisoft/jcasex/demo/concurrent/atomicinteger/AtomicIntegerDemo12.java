package cn.bevisoft.jcasex.demo.concurrent.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demo introduction: AtomicInteger累加操作 正确示例。
 * Demo description:
 * 通过20个线程并行针对一个AtomicInteger型totalCount变量累加，每个线程累加1000次，执行完之后理想的情况上20*1000=20000,
 * 把totalcount声明为AtomicInteger变量，在并发20个线程针对totalCount累加2万次之后，大部分情况还是totalCount==20000。
 * Demo notes:
 * 1.AtomicInteger能保障+1操作的原子性。
 * 2.AtomicInteger内部实现原理也是用cas原理(循环重试)+用volatile来保障线程间的可见性。
 *
 * @author bobo.wu
 * @version : AtomicIntegerDemo12.java, v 0.1 2020年03月14日 21:00 bobo.wu Exp $
 */
public class AtomicIntegerDemo12 {

    /**
     * 并发线程数量
     */
    private static final int THREAD_COUNT = 20;
    /**
     * 单个线程累加次数
     */
    private static final int THREAD_INCREASE_NUMBER = 1000;

    /**
     * 累加变量
     */
    public static AtomicInteger totalCount = new AtomicInteger(0);

    public static void increase() {
        totalCount.getAndAdd(1);
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < THREAD_INCREASE_NUMBER; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(totalCount);
    }
}