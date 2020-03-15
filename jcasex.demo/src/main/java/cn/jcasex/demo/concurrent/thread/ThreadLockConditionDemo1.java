package cn.jcasex.demo.concurrent.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @version $Id: ThreadLockConditionDemo1.java, v 0.1 2020年02月05日 16:37 bobo.wu Exp $
 */
public class ThreadLockConditionDemo1 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintABCRunable("A"));
        Thread threadB = new Thread(new PrintABCRunable("B"));
        Thread threadC = new Thread(new PrintABCRunable("C"));
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class PrintABCRunable implements Runnable {
    private Integer times = 10;
    private String charStr = null;
    private static ReentrantLock lock      = new ReentrantLock();
    private static Condition     condition = lock.newCondition();
    private static int           state     = 0;

    public PrintABCRunable(String charStr){
        this.charStr = charStr;
    }

    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < times; i++) {
                switch (charStr) {
                    case "A":
                        if (state % 3 != 0) {
                            condition.await();
                        }
                        System.out.println(charStr);
                        break;
                    case "B":
                        if (state % 3 != 1) {
                            condition.await();
                        }
                        System.out.println(charStr);
                        break;
                    case "C":
                        while (state % 3 != 2) {
                            condition.await();
                        }
                        System.out.println(charStr);
                        break;
                    default:
                        return;
                }
                state++;
                condition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}