package com.example.community.controller;


import com.example.community.dto.QuestionDto;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import com.example.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    //request 请求
    //controller 可以理解为 允许这个类接受前端的一个请求

 /*   @GetMapping("/hello")
    //name 定义变量的key 后面的参数定义值
    public String hello(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
*/
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){

        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        List<QuestionDto> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }


}
