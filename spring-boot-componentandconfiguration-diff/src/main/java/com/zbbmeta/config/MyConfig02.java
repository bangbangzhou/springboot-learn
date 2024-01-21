//package com.zbbmeta.config;
//
//import com.zbbmeta.entity.Tutorial;
//import com.zbbmeta.entity.Tutorial1;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: springboot葵花宝典
// * @Github: https://github.com/bangbangzhou
// * @description: TODO
// */
//@Component
//public class MyConfig02 {
//
//
//    @Bean
//    public Tutorial tutorial2() {
//        System.out.println("Component tutorial2() invoked...");
//        Tutorial tutorial = new Tutorial();
//        System.out.println("Tutorial: " + tutorial);
//        return tutorial;
//    }
//
//
//    @Bean
//    public Tutorial1 tutorial3() {
//        System.out.println("Component tutorial3() invoked...");
//        Tutorial tutorial =  tutorial2() ;
//        System.out.println("Component Tutorial: " + tutorial);
//        return new Tutorial1();
//    }
//
//}
