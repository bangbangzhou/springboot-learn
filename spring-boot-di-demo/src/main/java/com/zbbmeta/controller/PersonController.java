package com.zbbmeta.controller;

import com.zbbmeta.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@RequestMapping("/person")
@RestController
public class PersonController {


    @Autowired
    private Person person;

    @GetMapping
    public String getPerson(){
        return "name= "+  person.getName()+" age="+person.getAge();
    }
}
