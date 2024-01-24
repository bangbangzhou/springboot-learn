package com.zbbmeta.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName pe_role
 */
@TableName(value ="pe_role")
@Data
public class Role implements Serializable {
    @ExcelProperty("id")
    private String id;

    @ExcelProperty("权限名称")
    private String name;
    @ExcelProperty("描述")
    private String description;

    private static final long serialVersionUID = 1L;
}