package com.zbbmeta.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class Child {

    private int age;

//    @Builder.Default
    private String name="张三";
}
