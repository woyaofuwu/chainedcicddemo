package com.wdjr.springbootquick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sf.test;

//这个类的所有方法返回的数据直接返回给浏览器（如果是对象转为json数据）
/*@ResponseBody
@Controller*/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String  hello(){
        return "hello "+new Runner().getSecret();
    }
    //REST API
}
