package cn.jcasex.demo.concurrent.thread;

/**
 * Demo introduction: Thread#yield��ʾ�ó�����cpuִ�л��ᣨ����cpuʱ���Ƭ�������»��ѵȴ��̣߳��п��ܻ��ǻỽ���Լ���δ�ﵽ"����"��Ŀ�ģ���
 * Demo description:
 * ���������̣߳�ÿ���߳�˳���ӡ100�����֣�ÿ����ӡ��20������������ʱ������Thread.yield()�������ó�cpuִ�л��ᡣ
 * ������ʵ��ִ�й����У����ܻ��ó�ʧ�ܣ��������ֵ���Thread.yield()���߳��ˡ�
 * ���������´�ӡ�����
 * ��"�߳�1"��ӡ��40ʱ������Thread.yield()�õ������ó�ִ�л��ᣨ����cpuʱ���Ƭ����������ǵ�ǰ�̻߳����ִ�л��ᣨ������ӡ41����δ��������"�߳�2"ִ�У�
 * <pre>
 * �߳�1--39
 * �߳�1--40
 * �߳�1--41
 * �߳�1--42
 * </pre>
 * Demo notes:
 * 1. yield �ؼ��ֵ���������ʾ�������ó�����ִ�л��ᣬ��ʱ�������»��ѵȴ����е��̣߳���ѡһ���߳�ִ�У��п��ܻ��ǻ���ѡ�����̡߳�
 * 2. yield��sleep������sleep��ָ���˵ȴ�ʱ�䡣
 * 3. yield��sleep���������ͷŵ�ǰ��õ�����
 * @author bobo.wu
 * @version : ThreadYieldDemo10.java, v 0.1 2020��03��14�� 23:12 bobo.wu Exp $
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
        Thread threa1 = new Thread(runnable, "�߳�1");
        threa1.start();

        Thread threa2 = new Thread(runnable, "�߳�2");
        threa2.start();
    }
}