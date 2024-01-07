package com.zbbmeta.controller;

import com.zbbmeta.annotation.SensitiveMethod;
import com.zbbmeta.entity.Tutorial;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@RestController
@RequestMapping("tutorial")
public class TutorialController {



    @SensitiveMethod
    @PutMapping
    public Tutorial update(@RequestBody Tutorial tutorial){
        System.out.println("tutorial = " + tutorial);
        return tutorial;
    }


    @SensitiveMethod
    @GetMapping
    public Tutorial getTutorial(){

        Tutorial tutorial = new Tutorial();
        tutorial.setTitle("springboot葵花宝典");
        tutorial.setDescription("微信公众号");
        return tutorial;
    }
}
