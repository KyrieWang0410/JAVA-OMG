package com.example.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.example.domain.StoreFile;
import com.example.service.FileService;
import com.example.service.dto.FileDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class FileServiceImpl implements FileService {
    /**
     * 上传路径
     */
    final static private String FILE_PATH = "d:/file/";
    /**
     * 时间格式
     */
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public FileDTO getFileInfoById(Integer id) {
        return null;
    }

    @Override
    public FileDTO storeFile(byte[] content, String originFileName) {
        // 获取文件后缀生成目录路径, file.path + yyyyMMdd 格式组成文件夹路径
        String folder = LocalDateTime.now().format(dateTimeFormatter);
        String suffix = originFileName.substring(originFileName.lastIndexOf("."));
        String filePath = FILE_PATH + folder + File.separatorChar;
        // 保存文件并返回文件名
        String fileName = this.storeFile(content, filePath, suffix);

        // 入库（本例忽略插入DB操作）
        StoreFile file = new StoreFile();
        file.setName(fileName);
        file.setSuffix(suffix);
        file.setPath(folder);
        file.setOldName(originFileName);

        FileDTO fileDTO = new FileDTO();
        BeanUtils.copyProperties(file, fileDTO);

        return fileDTO;
    }

    @Override
    public void storeFileWithFileName(byte[] content, String path, String fileName) {
        // 目录不存在则创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        try (FileOutputStream os = new FileOutputStream(path + fileName); ByteArrayInputStream is = new ByteArrayInputStream(content)) {
            IOUtils.copy(is, os);
        } catch (IOException e) {
            log.error("存储文件到本地时发生异常：{}", e.getMessage());
        }

    }

    private String storeFile(byte[] content, String path, String suffix) {
        String fileName = generateFileName(suffix);
        storeFileWithFileName(content, path, fileName);
        return fileName;
    }

    private String generateFileName(String suffix) {
        return generateFileName() + suffix;
    }


    private String generateFileName() {
        return System.currentTimeMillis() + "_" + RandomUtil.randomNumbers(6);
    }


}
