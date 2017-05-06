package cn.jcasex.demo.concurrent;

import java.util.logging.Logger;

/**
 * 1.Daemon线程又名守护线程，作用是服务于其它用户线程，提供类似于垃圾回收、资源管理之类的。
 * 2.如果用户线程全部都执行完了，daemon就没有服务对象（用户线程）了，那么daemon线程生命周期也结束，随之退出。
 * 3.可以在线程启动前，通过setDaemon(boolean daemon)来把一个线程置为daemon线程。记住一定要在线程启动前设置。
 *
 *
 *
 * @author xubo.wuxb
 * @version $Id: DaemonDemo1.java, v 0.1 2017年05月05日 23:36 xubo.wuxb Exp $
 */
public class DaemonDemo1 implements Runnable {


    public static void main(String[] args){
        Thread daemonThread = new Thread(new DaemonDemo1());
        daemonThread.setDaemon(true);
        daemonThread.start();

        /**
         此例中有两个线程：
         一个是daemonThread线程，并在启动前设置为daemon线程，在daemon线程里打印1到5的数字，每隔500毫秒输出一个数字，执行完总共需要2.5秒；
         一个是main方法对应的线程，为用户线程，此用户线程负责把daemon的线程启动；，

         1.如果在main对应用户线程里把daemonThread join进来，则main对应的线程为用户线程，需要daemonThread线程经过2.5秒把1到5的数字全部打印完后，main对应用用户线程结束，然后daemonThread没有用户线程守护后就退出了。
         打印结果如下：
         DaemonThread run started
         DaemonThread run: 1
         DaemonThread run: 2
         DaemonThread run: 3
         DaemonThread run: 4
         DaemonThread run: 5
         DaemonThread run ended
         DaemonDemo1 main thread execute ended

         2.如果把daemonThread.join()注释掉，则用户线程只要把daemonThread线程启动之后，main方法对应的用户线程就执行完毕（打印出DaemonThread run ended）。而此时daemonThread线程还没有打印完5个数字，但是daemon线程已经没有用户线程可守护了，所以没有等打印完5个数字就结束退出了。
         打印结果是：
         DaemonDemo1 main thread execute ended
         DaemonThread run started
         DaemonThread run: 1
         **/


        try {
            daemonThread.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("DaemonDemo1 main thread execute ended");

    }

    public void run() {
        System.out.println("DaemonThread run started ");

        for (int index = 1;index<=5;index++){
            try {
                System.out.println("DaemonThread run: "+index);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("DaemonThread run ended ");
    }

}
