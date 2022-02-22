package com.bjpowernode.controller;

import com.bjpowernode.model.Sysuser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/tpl")
public class MyThymeleafController {

    @GetMapping("hello")
    public String helloThymeleaf(HttpServletRequest request){
         //添加数据到作用域，使用Thymeleaf就可以获得数据
        request.setAttribute("data","欢迎来到我的怀抱");
        //指定视图，用视图模板
        return "hello";

    }


    @GetMapping("/expression1")
    public String expression1(Model model){
        //把数据添加到model中，因为model本来就是在域中的
        model.addAttribute("site","www.hexiaolong1");
        model.addAttribute("myuser",new Sysuser(1001,"李四",10));
        return "expression1";
    }


    //链接表达式
    @GetMapping("link")
    public String link(Model model){
        model.addAttribute("userId",100);
        return "link";
    }

    @GetMapping("/queryAccount")
    @ResponseBody
    public String rest(Integer id){
        return "queryAccount,参数id" +id;
    }

    @GetMapping("/queryUser")
    @ResponseBody
    public String querUser(String name,Integer age){
        return "queryUser，名字和年龄" +name+age;
    }



}
