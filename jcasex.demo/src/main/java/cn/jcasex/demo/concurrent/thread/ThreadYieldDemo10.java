package cn.jcasex.demo.concurrent.thread;

/**
 * Demo introduction: Thread#yield提示让出本次cpu执行机会（本轮cpu时间分片），重新唤醒等待线程，有可能还是会唤醒自己（未达到"产出"的目的）。
 * Demo description:
 * 启动两个线程，每个线程顺序打印100个数字，每当打印到20的整数倍数字时，调用Thread.yield()方法，让出cpu执行机会。
 * 但是在实际执行过程中，可能会让出失败，调度器又调度Thread.yield()到线程了。
 * 如会出现如下打印情况：
 * 当"线程1"打印到40时，调用Thread.yield()让调度器让出执行机会（本次cpu时间分片），可最后还是当前线程获得了执行机会（继续打印41），未能如期让"线程2"执行，
 * <pre>
 * 线程1--39
 * 线程1--40
 * 线程1--41
 * 线程1--42
 * </pre>
 * Demo notes:
 * 1. yield 关键字的作用是提示调度器让出本次执行机会，此时调度重新唤醒等待队列的线程，挑选一个线程执行，有可能还是会挑选到本线程。
 * 2. yield与sleep的区别，sleep是指定了等待时间。
 * 3. yield与sleep，都不会释放当前获得的锁。
 * @author bobo.wu
 * @version : ThreadYieldDemo10.java, v 0.1 2020年03月14日 23:12 bobo.wu Exp $
 */
public class ThreadYieldDemo10 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
                if (i % 20 == 0) {
                    Thread.yield();
                }
            }
        };
        Thread threa1 = new Thread(runnable, "线程1");
        threa1.start();

        Thread threa2 = new Thread(runnable, "线程2");
        threa2.start();
    }
}