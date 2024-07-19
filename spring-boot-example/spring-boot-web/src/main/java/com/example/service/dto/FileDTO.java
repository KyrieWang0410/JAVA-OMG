package com.example.service.dto;

import lombok.Data;

import java.io.Serializable;
/**
 * FileDTO
 *
 * @author Kyrie.Wang
 */
@Data
public class FileDTO implements Serializable {
    /**
     * 文件ID
     */
    private Long id;
    /**
     * 源文件名
     */
    private String oldName;
    /**
     * 现文件名
     */
    private String name;
    /**
     * 文件类型
     */
    private String suffix;
    /**
     * 访问地址
     */
    private String url;
}
