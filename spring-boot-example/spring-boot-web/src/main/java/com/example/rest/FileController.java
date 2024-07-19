package com.example.rest;

import com.example.base.ResponseResult;
import com.example.common.annotation.AnonymousAccess;
import com.example.service.FileService;
import com.example.service.dto.FileDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * 文件相关控制类
 *
 * @author Kyrie.Wang
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("file")
public class FileController {

    private static final String DOWNLOAD_FILE_FOLDER = "D:\\file\\";

    private final FileService fileService;

    @PostMapping("/upload")
    @AnonymousAccess
    public String upload(@RequestParam("imgFile") MultipartFile file, @RequestParam("imgName") String name) throws IOException {
        // 设置上传至项目文件夹下的uploadFile文件夹中，没有文件夹则创建
        File dir = new File("uploadFile");
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                return "文件夹创建失败";
            }
        }
        file.transferTo(new File(dir.getAbsolutePath() + File.separator + name + ".png"));
        return "上传完成！文件名：" + name;
    }

    @PostMapping("/uploadMultiFile")
    public String upload(@RequestParam("imgFile") MultipartFile[] files, @RequestParam("imgColName") String name) throws IOException {
        File dir = new File("uploadFile");
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                return "文件夹创建失败";
            }
        }
        for (MultipartFile file : files) {
            file.transferTo(new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename()));
        }
        return "上传完成！图集名：" + name;
    }

    @PostMapping("/uploadByOne")
    @AnonymousAccess
    public ResponseResult uploadByOne(@RequestParam("file") MultipartFile file) {
        try (InputStream is = file.getInputStream(); ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            IOUtils.copy(is, os);
            byte[] bytes = os.toByteArray();
            FileDTO fileDTO = fileService.storeFile(bytes, file.getOriginalFilename());
            return ResponseResult.ok().data("data", fileDTO);
        } catch (IOException e) {
            log.error("文件上传发生异常 -> {}", e.getMessage());
            return ResponseResult.error().setMessage("文件上传失败");
        }
    }

    @GetMapping("/download")
    @AnonymousAccess
    public void downloadFile(HttpServletResponse response) throws IOException {
        // 获取文件
        String fileName = "新建DOCX文档.docx";
        byte[] fileNameBytes = fileName.getBytes(StandardCharsets.UTF_8);
        String decodedFileName = new String(fileNameBytes, StandardCharsets.UTF_8);
        File file = new File(DOWNLOAD_FILE_FOLDER + decodedFileName);


        // 设置响应头
        if (file.getName().endsWith(".pdf")) {
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        } else if (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")) {
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        } else if (file.getName().endsWith(".png")) {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        } else {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        }

        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        try (InputStream inputStream = Files.newInputStream(file.toPath())) {
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        }

    }

}
