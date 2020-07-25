package cn.jcasex.web.controller;

import org.junit.Assert;
import org.junit.Test;

/**
 * Home Controller Test
 **/
public class HomeControllerTest {

    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello,World!", new HomeController().sayHello());
    }
}
