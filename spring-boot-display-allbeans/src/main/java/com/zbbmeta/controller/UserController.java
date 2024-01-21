package com.zbbmeta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@RestController

public class UserController {

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping(value = "/displayallbeans")
    public void getHeaderAndBody() {

        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String beanName : beans) {
            System.out.println("===========================================");
            Class<?> beanType = applicationContext
                    .getType(beanName);
            System.out.println("BeanName:" + beanName);
            System.out.println("Bean的类型：" + beanType);
            System.out.println("Bean所在的包：" + beanType.getPackage());
            System.out.println("Bean：" + applicationContext.getBean(
                    beanName));


            applicationContext.isSingleton(beanName);
        }
    }
}
