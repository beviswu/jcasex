package cn.jcasex.demo.concurrent.atomic.atomicinteger;

/**
 * AtomicIntegerDemo10 for demo: 并发的情况针对int的累加操作不是原子操作。
 * Demo description:
 * 通过20个线程并行针对一个int型totalCount变量累加，每个线程累加1000次，执行完之后理想的情况上20*1000=20000,
 * 而实际上，在并发20个线程针对totalCount累加2万次之后，大部分情况totalCount<=20000，并且每次的结果值都不一样。
 * Demo notes:
 * 1.count++ 本身不是原子操作，没有做任何并发控制得不到逾期的结果。
 * @author bobo.wu
 * @version : AtomicIntegerDemo10.java, v 0.1 2020年03月14日 20:32 bobo.wu Exp $
 */
public class AtomicIntegerDemo10 {

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
    public static int totalCount = 0;

    public static void increase() {
        totalCount++;
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