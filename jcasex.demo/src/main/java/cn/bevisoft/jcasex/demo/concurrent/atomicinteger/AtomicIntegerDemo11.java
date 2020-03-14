package cn.bevisoft.jcasex.demo.concurrent.atomicinteger;

/**
 * AtomicIntegerDemo11 for demo: ��AtomicIntegerDemo10�Ļ����ϣ���totalCount������volatile�жϡ�
 * Demo description:
 * ͨ��20���̲߳������һ��int��totalCount�����ۼӣ�ÿ���߳��ۼ�1000�Σ�ִ����֮������������20*1000=20000,
 * ��Ȼ���totalcount����������volatile���Σ��ڲ���20���߳����totalCount�ۼ�2���֮�󣬴󲿷��������totalCount<=20000������ÿ�εĽ��ֵ����һ��������δ�ﵽ���ڵĽ����
 * Demo notes:
 * 1.volatileֻ�ܡ�����totalCount�Ĳ��������������߳̿ɼ��ԡ��͡���ָֹ�����š������ǲ����ܽ��ԭ���Ե�����
 * @author bobo.wu
 * @version : AtomicIntegerDemo11.java, v 0.1 2020��03��14�� 20:32 bobo.wu Exp $
 */
public class AtomicIntegerDemo11 {

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