//package com.zbbmeta.config;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author: springboot葵花宝典
// * @Github: https://github.com/bangbangzhou
// * @description: TODO
// */
//@Configuration
//public class JacksonConfig {
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        // 设置在序列化时不包括值为null的字段
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        // 其他定制配置，根据需要添加
//
//        return objectMapper;
//    }
//}