package com.demo.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileDownloadController {

    @GetMapping("/download")
    public ResponseEntity<Resource> download() throws MalformedURLException {
        //获取资源文件
        String resourceFileName = "test_template_file.xls";
        Path filePath = Paths.get("F:\\test").resolve(resourceFileName).normalize();

        Resource resource = new UrlResource(filePath.toUri());

        String encodedFileName = URLEncoder.encode("导入模板.xls", StandardCharsets.UTF_8)
                .replace("+", "%20");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + encodedFileName + "\";" +
                        "filename*=UTF-8''" + encodedFileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
