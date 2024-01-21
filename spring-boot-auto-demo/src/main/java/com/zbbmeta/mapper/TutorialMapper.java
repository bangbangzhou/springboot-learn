package com.zbbmeta.mapper;

import com.zbbmeta.entity.Tutorial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zbb
* @description 针对表【tb_tutorial】的数据库操作Mapper
* @createDate 2024-01-18 22:35:05
* @Entity com.zbbmeta.entity.Tutorial
*/
@Mapper
public interface TutorialMapper extends BaseMapper<Tutorial> {

}




