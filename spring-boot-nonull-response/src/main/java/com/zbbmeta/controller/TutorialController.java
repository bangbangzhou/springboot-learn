package com.zbbmeta.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zbbmeta.api.Result;
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




    @GetMapping
    public Result getTutorial(){

        Tutorial tutorial = new Tutorial();
        tutorial.setTitle("springboot葵花宝典");
        tutorial.setDescription("微信公众号");
        return Result.SUCCESS(tutorial)  ;
    }
}
