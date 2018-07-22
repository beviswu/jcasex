package cn.jcasex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Home Controller
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