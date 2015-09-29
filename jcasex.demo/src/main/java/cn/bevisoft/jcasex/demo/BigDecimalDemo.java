package cn.bevisoft.jcasex.demo;

import java.math.BigDecimal;

public class BigDecimalDemo {
    
    public static void main(String[] args) {
        case01();
    }
    
    private static void case01(){
        BigDecimal d1 = new BigDecimal("0.11");
        System.out.println("new BigDecimal(\"0.11\").intValue()="+d1.intValue());
        
        d1 = new BigDecimal("0.99");
        System.out.println("new BigDecimal(\"0.99\").intValue()="+d1.intValue());
        
        d1 = new BigDecimal("1.99");
        System.out.println("new BigDecimal(\"1.99\").intValue()="+d1.intValue());
        
    }

}
