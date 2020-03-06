package com.example.community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    //request 请求
    //controller 可以理解为 允许这个类接受前端的一个请求

 /*   @GetMapping("/hello")
    //name 定义变量的key 后面的参数定义值
    public String hello(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
*/
    public String index(){
        return "index";
    }
}
