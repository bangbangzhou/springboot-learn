package com.zbbmeta.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName tb_tutorial
 */
@TableName(value ="tb_tutorial")
@Data
public class Tutorial implements Serializable {
    @ExcelProperty("id")
    private Long id;
    @ExcelProperty("标题")
    private String title;
    @ExcelProperty("表述")
    private String description;
    @ExcelProperty("是否发布")
    private Integer published;

    private static final long serialVersionUID = 1L;
}