# SpringBoot使用Thymeleaf生成PDF

>在现代Web应用中，生成PDF文件是一个常见的需求。为了满足这一需求，**我们可以利用Spring Boot集成Thymeleaf和Flying Saucer PDF来生成具有丰富内容的PDF文件**。Thymeleaf作为模板引擎，提供了简单而强大的模板语法，而Flying Saucer PDF则是一个用于将HTML转换为PDF的工具

今日内容介绍，大约花费9分钟

![](https://files.mdnice.com/user/7954/012f3922-8878-412f-82ea-65e051ca7a59.png)


## 1. 选择Thymeleaf和Flying Saucer的原因

### Thymeleaf的强大模板引擎
>Thymeleaf是一款为HTML和XML文档提供自然模板语法的模板引擎。它的语法清晰简单，易于学习和使用，同时支持强大的逻辑操作。与Spring Boot紧密集成，使得在Spring Boot应用中使用Thymeleaf非常方便。

### Flying Saucer PDF的HTML转PDF能力
>Flying Saucer PDF是一个用于将HTML和CSS转换为PDF的Java库。它支持CSS2.1和部分CSS3，因此我们可以使用Thymeleaf生成的HTML作为输入，从而实现更丰富的PDF内容

## 2. 代码实现步骤
完整项目结构如下:

![](https://files.mdnice.com/user/7954/b57fe3a2-d545-457f-bc26-fd475b87a1e1.png)

### 【步骤一】:在pom.xml中添加依赖
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>spring-boot-starter-parent</artifactId>
        <groupId>org.springframework.boot</groupId>
        <version>2.7.15</version>
    </parent>
  <modelVersion>4.0.0</modelVersion>

  <artifactId>spring-boot-generate-pdf-thymeleaf</artifactId>

  <properties>
      <maven.compiler.source>11</maven.compiler.source>
      <maven.compiler.target>11</maven.compiler.target>
  </properties>

  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
      </dependency>

      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
      </dependency>

      <!-- Spring Boot Starter Thymeleaf -->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-thymeleaf</artifactId>
      </dependency>

      <!-- Flying Saucer PDF -->
      <dependency>
          <groupId>org.xhtmlrenderer</groupId>
          <artifactId>flying-saucer-pdf</artifactId>
          <version>9.3.1</version>
      </dependency>
  </dependencies>

</project>


```

### 【步骤二】：在yml中添加thymeleaf配置
```yml
server:
  port: 8899

spring:
  thymeleaf:
    prefix: classpath:/templates/
    suffix: .html
    mode: HTML
    encoding: UTF-8
    servlet:
      content-type: text/html
    cache: false
```

### 【步骤三】:创建Thymeleaf模板文件
创建Thymeleaf模板文件（例如）：路径如下` src/main/resources/templates/mytemplate.html`
```html
<!-- src/main/resources/templates/mytemplate.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>PDF Document</title>
</head>
<!--这样配置不中文不会显示-->
<!--<body style="font-family: 宋体">-->
<body style="font-family: 'SimSun'">
<h1 th:text="${title}">Default Title</h1>
<p th:text="${content}">Default Content</p>
</body>
</html>

```

### 【步骤四】：建PDF生成服务
创建PdfGenerationService类，该类负责将Thymeleaf模板渲染成HTML，并使用Flying Saucer将HTML转换为PDF：
```java
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

```
<font color="red" size="4">注意:我们要设置字体，不然不支持中文</font>

[SimSun字体下载地址](https://github.com/StellarCN/scp_zh/blob/master/fonts/SimSun.ttf)

### 【步骤五】:创建Controller
创建一个简单的Controller，用于接收请求并调用PdfGenerationService生成PDF：
```java
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

```

### 【步骤六】:创建启动类
```java
@SpringBootApplication
public class GeneratePdfFromThymeleadApp {
    public static void main(String[] args) {
        SpringApplication.run(GeneratePdfFromThymeleadApp.class,args);
    }
}

```

##  测试
- 启动你的Spring Boot应用，并访问 `http://localhost:8080/pdf/generate`。你将获得一个包含自定义标题和内容的PDF文件。

![](https://files.mdnice.com/user/7954/07e5a9e1-e007-401b-93c2-7a2ad2a2def4.png)

- 访问`http://localhost:8899/pdf/generate?title=自定义标题&content=测试内容` 切换默认标题和内容

![](https://files.mdnice.com/user/7954/620db43f-3b78-44bd-9374-c3678d7811ce.png)

**总结**
通过结合Spring Boot、Thymeleaf和Flying Saucer PDF，我们可以轻松生成包含动态内容的PDF文件。**确保Thymeleaf模板文件正确设置字符集，以支持中文输出。这个例子提供了一个简单的方法来实现PDF生成，你可以根据实际需求进行扩展和定制**。
