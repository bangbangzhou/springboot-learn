package com.zbbmeta.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;


//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Tutorial implements Serializable {


    private Long id;

    private String title;

    private String description;
    private Integer published;

    private static final long serialVersionUID = 1L;
}
