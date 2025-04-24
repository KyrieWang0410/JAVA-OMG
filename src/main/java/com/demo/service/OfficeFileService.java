package com.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 描述: 提供对办公文件（如Word、Excel等）的操作服务接口。
 *
 * @author [Kyrie.Wang]
 * @version 1.0
 * @since 2025-04-23
 *
 * <p>此接口定义了处理办公文件的基本操作，包括上传、下载和删除等功能。</p>
 */
public interface OfficeFileService {

    /**
     * 描述: 从指定的Excel文件中读取数据并返回为一个列表。
     *
     * @param filePath [Excel文件的路径，类型为String]
     * @return List<Map < String, Object>> [返回一个包含每行数据的列表，每行数据以Map形式表示，键为列名，值为单元格内容]
     * @throws IOException [如果读取文件时发生IO异常]
     *
     *                     <p>详细描述: 该方法用于读取指定路径的Excel文件，解析文件内容并将每行数据存储在一个列表中，列表中的每个元素都是一个Map，表示一行数据。</p>
     */
    List<Map<String, Object>> readExcelData(String filePath) throws IOException;
}
