package com.zbbmeta.config;

import com.zbbmeta.entity.Dog;
import com.zbbmeta.entity.Person;
import com.zbbmeta.entity.Tutorial;
import com.zbbmeta.entity.Tutorial1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@Component
public class MyConfig01 {


//    @Bean
//    Dog dog(){
//        return new Dog();
//    }
//
//    @Bean
//    Person person(){
//        Person person = new Person();
//        //注意，这里是将上面注册到Spring中的dog,set到person
//        person.setDog(dog());
//        return person;
//    }
}
