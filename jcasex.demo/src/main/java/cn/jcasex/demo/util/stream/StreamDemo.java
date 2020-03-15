package cn.jcasex.demo.util.stream;

import cn.jcasex.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author bobo.wu
 * @version : StreamDemo.java, v 0.1 2020��02��17�� 11:27 bobo.wu Exp $
 */
public class StreamDemo {
    public static void main(String[] args) {
        list2Map();
    }

    public static void list2Map(){
        List<User> list =new ArrayList<>();

       Map<String,User> map = list.stream().collect(
                Collectors.toMap(User::getUserId, user -> user));

        System.out.println(map);

    }
}