package com.zbbmeta.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

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
@Slf4j
@Component
public class ExcelExportUtil<T, E> {

    /**
     * 多个子页签导出功能
     *
     * @param response  响应流
     * @param fileName  导出的文件名
     * @param data      导出的数据
     * @param classArgs 导出的页签EXCEL类
     * @throws Exception
     */
    public void exportMultipleSheetData(HttpServletResponse response, String fileName, Map<Class, List<? extends Object>> data, Class<E>... classArgs) throws IOException {
        this.exportMergeMultipleSheetData(response, fileName, null, 0, data, classArgs);
    }

    /**
     * 多个子页签导出并且合并功能
     *
     * @param response         响应流
     * @param fileName         导出的文件名
     * @param mergeColumnIndex 需要合并的列
     * @param mergeRowIndex    设置第几行开始合并
     * @param data             导出的数据
     * @param classArgs        导出的页签EXCEL类
     * @throws Exception
     */
    public void exportMergeMultipleSheetData(HttpServletResponse response, String fileName, int[] mergeColumnIndex, int mergeRowIndex,
                                             Map<Class, List<? extends Object>> data, Class<E>... classArgs) throws IOException {
        try {
            fileName = new String(fileName.getBytes(), "UTF-8");
            log.info("导出的文件名为：" + fileName);
            response.addHeader("Content-Disposition", "filename=" + fileName);
            //设置类型，扩展名为.xls
            response.setContentType("application/vnd.ms-excel");
            //将数据写入sheet页中
            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
            // 遍历每个页签实体
            for (int i = 0; i < classArgs.length; i++) {
                // 判断数据中是否存在实体类，如果存在则做导出
                if (data.containsKey(classArgs[i])) {
                    String name = classArgs[i].getName().replace(classArgs[i].getPackageName()+".","");
                    WriteSheet writeSheet = EasyExcel.writerSheet(i, name).head(classArgs[i]).build();
                    excelWriter.write(data.get(classArgs[i]), writeSheet);
                }
            }
            excelWriter.finish();
            log.info("导出文件《" + fileName + "》成功");
            response.flushBuffer();
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }
}