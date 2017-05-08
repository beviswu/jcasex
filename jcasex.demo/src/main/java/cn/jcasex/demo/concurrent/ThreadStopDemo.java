package cn.jcasex.demo.concurrent;

import cn.jcasex.demo.concurrent.domain.User;

/**
 * Thread的stop方法现在已经废弃，原因是stop的时候有可能损坏数据的一致性。
 * 本例中通一个线程不断的循环去修改User的name和age属性，并且把name设置为name_x，把age设置为age_x,其中x会随着每次循环递增，正常情况name和age的x数字是相同的。
 * 但是有可能线程正好把name的属性更新好之后，正准备更新age属性的时候线程被stop，此时就会造成数据不一致。
 * 本例中为了更好的呈现问题，就在更新name和更新age之间使用thead.slepp，尽早的重现问题。
 *
 */
public class ThreadStopDemo  implements Runnable {

    private static User user= new User();

    private static final  String NAME_PREFIX = "USER_";
    private static final  String AGE_PREFIX = "AGE_";

    public void run() {
        for(int i=1;i<100;i++) {
            user.setName(NAME_PREFIX + i);

            System.out.println("set name="+NAME_PREFIX + i);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            user.setAge(AGE_PREFIX+i);
            System.out.println("set age="+AGE_PREFIX+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {


        Thread threadStop = new Thread(new ThreadStopDemo());
        threadStop.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        /**
         * 使用thread.stop后，User对象的name和age可能不致，有时候会输出类似于这样的结果
         * after thead stop,the user:User{name='USER_4', age='AGE_3'} //这里的name后面的数字是4，但是Age后面的数字是3，出现不致了
         **/
        threadStop.stop();
        System.out.println("after thead stop,the user:"+user.toString());




    }
}
