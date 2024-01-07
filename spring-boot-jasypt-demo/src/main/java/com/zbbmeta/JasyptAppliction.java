package com.zbbmeta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@EnableAspectJAutoProxy
@MapperScan("com.zbbmeta.mapper")
@SpringBootApplication
public class JasyptAppliction {

    public static void main(String[] args) {
        SpringApplication.run(JasyptAppliction.class,args);

    }
}
