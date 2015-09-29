package cn.bevisoft.jcasex.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URL;


public class LineNumberReaderDemo {
    
    public static void main(String[] args) throws IOException {
        demo1();
    }
    
    private static void demo1() throws IOException{
        String fileName = "jianwen.ljw_2014-5-12-13-30-46_EN.dat";
        
        //URL url = LineNumberReaderDemo.class.getResource("");
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        
        String path = url.getPath().substring(1);
        System.out.println(path);;
        //String fullFileNname  = path+"files"+File.separator+fileName;
        String fullFileNname  = "D:\\bevis.github\\jcasex\\jcasex.demo\\src\\main\\resources\\META-INF\\jianwen.ljw_2014-5-12-13-30-46_EN.dat";
        
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fullFileNname));
        for(int i=0,total=10;i<total;i++){
            String strLine = lineNumberReader.readLine();
            System.out.println(lineNumberReader.getLineNumber()+":"+strLine);
        }
    }

}
