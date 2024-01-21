package com.zbbmeta.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@AutoConfigurationPackage(basePackages = "com.zbbmeta")
@ComponentScan(basePackages = "com.zbbmeta")
@SpringBootApplication
public class AutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoApplication.class,args);
    }
}
