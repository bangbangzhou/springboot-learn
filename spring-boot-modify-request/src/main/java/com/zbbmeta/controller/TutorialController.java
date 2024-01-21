package com.zbbmeta.controller;


import com.zbbmeta.entity.Tutorial;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@Controller
@ResponseBody
@RestController
@RequestMapping("tutorial")
public class TutorialController {


    @GetMapping
    @ResponseBody
    public String update(){

        return "test";
    }




    @PutMapping
    @ResponseBody
    public Tutorial update(@RequestBody Tutorial tutorial){
        System.out.println("tutorial = " + tutorial);
        return tutorial;
    }


}
