package cn.jcasex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Home Controller
 * @author xubo.wuxb
 * @version $Id: HomeController.java, v 0.1 2018年07月21日 23:55 xubo.wuxb Exp $
 */
@Controller
public class HomeController {

    @RequestMapping(value="/hello",method= RequestMethod.GET)
    @ResponseBody
    public String greeting() {
        return "index";
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String sayHello() {
        return "Hello,World!";
    }
}