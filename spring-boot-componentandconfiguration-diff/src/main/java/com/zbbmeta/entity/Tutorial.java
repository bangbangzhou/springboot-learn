package com.zbbmeta.entity;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName tb_tutorial
 */

@Builder
@Data
public class Tutorial implements Serializable {
    private Long id;

    private String title="springboot葵花宝典";



    private String description;

    private Integer published;

    private static final long serialVersionUID = 1L;


}