package cn.jcasex.demo.concurrent.atomic.atomicinteger;

/**
 * AtomicIntegerDemo10 for demo: ������������int���ۼӲ�������ԭ�Ӳ�����
 * Demo description:
 * ͨ��20���̲߳������һ��int��totalCount�����ۼӣ�ÿ���߳��ۼ�1000�Σ�ִ����֮������������20*1000=20000,
 * ��ʵ���ϣ��ڲ���20���߳����totalCount�ۼ�2���֮�󣬴󲿷����totalCount<=20000������ÿ�εĽ��ֵ����һ����
 * Demo notes:
 * 1.count++ ������ԭ�Ӳ�����û�����κβ������Ƶò������ڵĽ����
 * @author bobo.wu
 * @version : AtomicIntegerDemo10.java, v 0.1 2020��03��14�� 20:32 bobo.wu Exp $
 */
public class AtomicIntegerDemo10 {

    /**
     * �����߳�����
     */
    private static final int THREAD_COUNT = 20;
    /**
     * �����߳��ۼӴ���
     */
    private static final int THREAD_INCREASE_NUMBER = 1000;

    /**
     * �ۼӱ���
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