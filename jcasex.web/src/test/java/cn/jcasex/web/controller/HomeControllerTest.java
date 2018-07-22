package cn.jcasex.web.controller;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author xubo.wuxb
 * @version $Id: HomeControllerTest.java, v 0.1 2018年07月22日 12:04 xubo.wuxb Exp $
 */
public class HomeControllerTest {

    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello,World!",new HomeController().sayHello());
    }
}