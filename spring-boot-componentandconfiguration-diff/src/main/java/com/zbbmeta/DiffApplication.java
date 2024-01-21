package com.zbbmeta;

import com.zbbmeta.config.MyConfig01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.xmlunit.diff.Diff;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@SpringBootApplication
public class DiffApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DiffApplication.class, args);

    }
}
