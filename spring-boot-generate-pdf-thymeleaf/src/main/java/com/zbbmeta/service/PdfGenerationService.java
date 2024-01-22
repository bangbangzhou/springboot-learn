package com.zbbmeta.service;

import com.lowagie.text.pdf.BaseFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
@Service
public class PdfGenerationService {

    @Autowired
    private  TemplateEngine templateEngine;



    public byte[] generatePdf(Map<String, Object> data) {
        String htmlContent = templateEngine.process("mytemplate", new Context(Locale.getDefault(), data));
        return convertHtmlToPdf(htmlContent);
    }

    private byte[] convertHtmlToPdf(String htmlContent) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            // 设置中文字体
            renderer.getFontResolver().addFont("templates/SimSun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            // 处理异常
            return new byte[0];
        }
    }
}
