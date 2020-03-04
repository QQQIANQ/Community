package com.example.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {
    //Springboot大大的节省了我们的开发和学习成本
    //用容器去管理bean
    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
