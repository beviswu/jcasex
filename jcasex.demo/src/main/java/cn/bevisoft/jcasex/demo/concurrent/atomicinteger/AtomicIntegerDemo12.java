package cn.bevisoft.jcasex.demo.concurrent.atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demo introduction: AtomicInteger�ۼӲ��� ��ȷʾ����
 * Demo description:
 * ͨ��20���̲߳������һ��AtomicInteger��totalCount�����ۼӣ�ÿ���߳��ۼ�1000�Σ�ִ����֮������������20*1000=20000,
 * ��totalcount����ΪAtomicInteger�������ڲ���20���߳����totalCount�ۼ�2���֮�󣬴󲿷��������totalCount==20000��
 * Demo notes:
 * 1.AtomicInteger�ܱ���+1������ԭ���ԡ�
 * 2.AtomicInteger�ڲ�ʵ��ԭ��Ҳ����casԭ��(ѭ������)+��volatile�������̼߳�Ŀɼ��ԡ�
 *
 * @author bobo.wu
 * @version : AtomicIntegerDemo12.java, v 0.1 2020��03��14�� 21:00 bobo.wu Exp $
 */
public class AtomicIntegerDemo12 {

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