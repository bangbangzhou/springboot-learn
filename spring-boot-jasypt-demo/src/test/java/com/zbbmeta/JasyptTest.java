package com.zbbmeta;

import com.zbbmeta.entity.Tutorial;
import com.zbbmeta.service.TutorialService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@SpringBootTest
public class JasyptTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void test1(){
        String encryptStr = stringEncryptor.encrypt("root");


        System.out.println("加密后的内容：" + encryptStr);
    }

    @Test
    public void test2(){


        String decrypt = stringEncryptor.decrypt("23WuA8R+tUK7pIfurUH38Q==");
        System.out.println("解密后的内容：" + decrypt);
    }

    @Autowired
    TutorialService tutorialService;
    
    @Test
    public void test3(){

        Tutorial tutorial = tutorialService.getById(1736743535144022018L);
        System.out.println("tutorial = " + tutorial);
    }
}
