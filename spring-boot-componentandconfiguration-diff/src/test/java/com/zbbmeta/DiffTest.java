package com.zbbmeta;

import com.zbbmeta.config.MyConfig01;
import com.zbbmeta.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */

@SpringBootTest
public class DiffTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DiffApplication.class);
        MyConfig01 config01 = ctx.getBean(MyConfig01.class);

        System.out.println("config01 = " + config01);
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DiffApplication.class);

//        Person person = ctx.getBean("person", Person.class);
//        Dog dog = ctx.getBean("dog", Dog.class);
//        boolean result = person.getDog() == dog;
//        System.out.println(result ? "同一个dog" : "不同的dog");

    }


    @Test
    public void test2() {
        Child child = Child.builder().build();
        System.out.println("child = " + child);

//        Child child1 = new Child();
//        System.out.println("child1 = " + child1);

    }

    @Test
    public void test3() {
        Child child = new Child().toBuilder().build();
        System.out.println("child = " + child);

        Child child1 = new Child();
        System.out.println("child1 = " + child1);




    }

    @Test
    public void studentTest() {

        Student student = new Student().toBuilder().build();
        System.out.println("student = " + student);

        Student student1 = new Student();
        System.out.println("student1 = " + student1);
    }
    @Test
    public void studentTest2() {

        Student student = new Student().toBuilder().build();
        System.out.println("student = " + student);

        Student student1 = new Student();
        System.out.println("student1 = " + student1);
    }
}
