package com.zbbmeta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbbmeta.annotation.SensitiveMethod;
import com.zbbmeta.entity.Tutorial;
import com.zbbmeta.service.TutorialService;
import com.zbbmeta.mapper.TutorialMapper;
import org.springframework.stereotype.Service;

/**
* @author zbb
* @description 针对表【tb_tutorial】的数据库操作Service实现
* @createDate 2024-01-07 15:08:57
*/

@Service
public class TutorialServiceImpl extends ServiceImpl<TutorialMapper, Tutorial>
    implements TutorialService{

}




