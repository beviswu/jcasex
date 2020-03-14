package cn.bevisoft.jcasex.demo.concurrent.atomicinteger;

/**
 * AtomicIntegerDemo11 for demo: 在AtomicIntegerDemo10的基础上，对totalCount增加了volatile判断。
 * Demo description:
 * 通过20个线程并行针对一个int型totalCount变量累加，每个线程累加1000次，执行完之后理想的情况上20*1000=20000,
 * 虽然针对totalcount变量上增加volatile修饰，在并发20个线程针对totalCount累加2万次之后，大部分情况还是totalCount<=20000，并且每次的结果值都不一样，还是未达到逾期的结果。
 * Demo notes:
 * 1.volatile只能“保障totalCount的操作在其它并发线程可见性”和“防止指令重排”，但是并不能解决原子性的问题
 * @author bobo.wu
 * @version : AtomicIntegerDemo11.java, v 0.1 2020年03月14日 20:32 bobo.wu Exp $
 */
public class AtomicIntegerDemo11 {

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
    public static volatile int totalCount = 0;

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