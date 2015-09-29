package cn.bevisoft.jcasex.demo;

import java.util.Arrays;

public class StringSplitDemo {
    
    public static void main(String[] args) {
        System.out.println("==============");
        String str = "32121_2013-12-17-15-40-44";
        String strArray[] = str.split("_");
        System.out.println("\""+str+"\".split(\"_\"),strArray[].length="+strArray.length);
        System.out.println("strArray[]="+Arrays.toString(strArray));
        System.out.println("==============");
        
        
        str = "32121_2013-12-17-15-40-44_";
        strArray = str.split("_");
        System.out.println("\""+str+"\".split(\"_\"),strArray[].length="+strArray.length);
        System.out.println("strArray[]="+Arrays.toString(strArray));
        System.out.println("==============");
        
        //String str = "32121_2013-12-17-15-40-44";
    }
    

}
