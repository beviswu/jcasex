package cn.bevisoft.jcasex.demo.concurrent;

/**
 * 单例模式
 * @author xubo.wuxb
 *
 */
public class SingletonDemo {
    
    private static volatile SingletonDemo instance;
    
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null)
                    instance = new SingletonDemo();
            }
        }
        return instance;
    }
    
    private SingletonDemo(){
        
    }

}
