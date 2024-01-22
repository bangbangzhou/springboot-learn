package com.zbbmeta.controller;

import com.zbbmeta.service.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: springboot葵花宝典
 * @Github: https://github.com/bangbangzhou
 * @description: TODO
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    private final PdfGenerationService pdfGenerationService;

    @Autowired
    public PdfController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @GetMapping("/generate")
    public void generatePdf(@RequestParam(defaultValue = "Custom Title") String title,
                            @RequestParam(defaultValue = "Custom Content") String content,
                            HttpServletResponse response) throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("title", title);
        data.put("content", content);

        byte[] pdfBytes = pdfGenerationService.generatePdf(data);

        response.setContentType("application/pdf");

        response.setHeader("Content-Disposition", "inline; filename=generated.pdf");
        response.getOutputStream().write(pdfBytes);
        response.flushBuffer();
    }
}
