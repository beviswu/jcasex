package cn.bevisoft.jcasex.demo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        demo1();
        

    }
    
    private static void demo1(){
        List<String> list1 = null;
        List<String> list2 = null;
        List<String> list3 = new ArrayList<String>();
        list2 = (List<String>)list1;
        System.out.println(list2==null);
    }

}
