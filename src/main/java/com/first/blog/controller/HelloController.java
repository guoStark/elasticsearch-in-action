package com.first.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello 控制器
 */
@Controller
public class HelloController {

    @RequestMapping("/Hello")
    @ResponseBody
    public String hello(){
        return "Hello world123";
    }


}
