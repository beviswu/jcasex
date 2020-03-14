package cn.jcasex.demo.concurrent.thread;

/**
 * Demo introduction: Thread#sleep(time)提示调度器当前线程在指定时间内不再执行（在指定时间内不再占用cpu的执行机会），让其它线程获取cpu的执行机会。
 * Demo description:
 * 启动两个线程，每个线程顺序打印100个数字，每当打印到20的整数倍数字时，调用Thread.sleep(10s)方法，在接下来的10s内当前线程不再占有cpu的时间。
 * 打印情况如下：
 * <pre>
 * 线程2-1584202263744--80
 * 线程2-1584202263744-- sleep 10s
 * 线程1-1584202263741--65
 * 线程1-1584202263744--66
 * 线程1-1584202263744--67
 * 线程1-1584202263744--68
 * </pre>
 * Demo notes:
 * 1. sleep 关键字的作用是提示调度器在指定时间内让出cpu的执行机会。
 * 2. sleep不会释放当前获得的锁。
 * 3. sleep后，线程进入block状态（待验证），而yield后线程不是进入block状态，而是进入runable状态
 * @author bobo.wu
 * @version : ThreadSleepDemo10.java, v 0.1 2020年03月14日 23:56 bobo.wu Exp $
 */
public class ThreadSleepDemo10 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 1; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "--" + i);
                if (i % 20 == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "-- sleep 10s" );
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread threa1 = new Thread(runnable, "线程1");
        threa1.start();

        Thread threa2 = new Thread(runnable, "线程2");
        threa2.start();
    }
}