package com.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Kyrie.Wang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StoreFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件ID
     */
    private Long id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型
     */
    private String suffix;

    /**
     * 文件相对路径
     */
    private String path;

    /**
     * 文件原名字
     */
    private String oldName;

}
