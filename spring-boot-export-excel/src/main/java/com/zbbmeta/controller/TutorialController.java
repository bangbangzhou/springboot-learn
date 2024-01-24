package com.zbbmeta.controller;

import com.zbbmeta.entity.Role;
import com.zbbmeta.entity.Tutorial;
import com.zbbmeta.service.RoleService;
import com.zbbmeta.service.TutorialService;
import com.zbbmeta.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@RestController
@RequestMapping("/tutorial")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @Autowired
    private RoleService roleService;


    @Autowired
    private ExcelExportUtil excelExportUtil;

    @PostMapping("/export")
    public void packageItemsExportNew( HttpServletResponse response) throws IOException {
        // 导出文件名
        String fileName = "test";
        List<Tutorial> list = tutorialService.list();
        List<Role> list1 = roleService.list();
        // 填充数据到每个子页签
        Map<Class, List<? extends Object>> dataMap = new HashMap<>();
        dataMap.put(Tutorial.class, list);
        dataMap.put(Role.class, list1);
        // 导出多个子页签的数据，不进行合并
        excelExportUtil.exportMultipleSheetData(response, fileName, dataMap, Tutorial.class,Role.class);
    }
}
