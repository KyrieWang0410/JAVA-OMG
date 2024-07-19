package com.example.service;

import com.example.service.dto.FileDTO;

/**
 * FileService 文件服务接口
 *
 * @author Kyrie.Wang
 */
public interface FileService {
    /**
     * 根据ID获取文件信息
     *
     * @param id 文件ID
     */
    FileDTO getFileInfoById(Integer id);


    /**
     * @param content 文件二进制
     * @param originFileName 文件源名字
     * @return com.example.service.dto.FileDTO
     */
    FileDTO storeFile(byte[] content, String originFileName);


    /**
     * 存储文件到本地
     *
     * @param content 文件二进制
     * @param path 文件路径
     * @param fileName 文件名
     */
    void storeFileWithFileName(byte[] content, String path, String fileName);


}
