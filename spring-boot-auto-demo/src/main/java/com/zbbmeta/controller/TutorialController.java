package com.zbbmeta.controller;


import com.zbbmeta.entity.Tutorial;
import com.zbbmeta.service.TutorialService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@RestController
@RequestMapping("tutorial")
public class TutorialController {

    @Setter(onMethod_ ={@Autowired} )
    private  TutorialService tutorialService;





    @GetMapping("/{id}")
    public Tutorial getTutorialById(@PathVariable Long id){
       return tutorialService.getById(id);
    }



    @PutMapping
    public Tutorial update(@RequestBody Tutorial tutorial){
        System.out.println("tutorial = " + tutorial);
        return tutorial;
    }



    @GetMapping
    public Tutorial getTutorial(){

        Tutorial tutorial = new Tutorial();
        tutorial.setTitle("springboot葵花宝典");
        tutorial.setDescription("微信公众号");
        return tutorial;
    }
}
