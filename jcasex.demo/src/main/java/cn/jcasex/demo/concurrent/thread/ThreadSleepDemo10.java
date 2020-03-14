package cn.jcasex.demo.concurrent.thread;

/**
 * Demo introduction: Thread#sleep(time)��ʾ��������ǰ�߳���ָ��ʱ���ڲ���ִ�У���ָ��ʱ���ڲ���ռ��cpu��ִ�л��ᣩ���������̻߳�ȡcpu��ִ�л��ᡣ
 * Demo description:
 * ���������̣߳�ÿ���߳�˳���ӡ100�����֣�ÿ����ӡ��20������������ʱ������Thread.sleep(10s)�������ڽ�������10s�ڵ�ǰ�̲߳���ռ��cpu��ʱ�䡣
 * ��ӡ������£�
 * <pre>
 * �߳�2-1584202263744--80
 * �߳�2-1584202263744-- sleep 10s
 * �߳�1-1584202263741--65
 * �߳�1-1584202263744--66
 * �߳�1-1584202263744--67
 * �߳�1-1584202263744--68
 * </pre>
 * Demo notes:
 * 1. sleep �ؼ��ֵ���������ʾ��������ָ��ʱ�����ó�cpu��ִ�л��ᡣ
 * 2. sleep�����ͷŵ�ǰ��õ�����
 * 3. sleep���߳̽���block״̬������֤������yield���̲߳��ǽ���block״̬�����ǽ���runable״̬
 * @author bobo.wu
 * @version : ThreadSleepDemo10.java, v 0.1 2020��03��14�� 23:56 bobo.wu Exp $
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
        Thread threa1 = new Thread(runnable, "�߳�1");
        threa1.start();

        Thread threa2 = new Thread(runnable, "�߳�2");
        threa2.start();
    }
}