package com.demo.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.service.OfficeFileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfficeFileServiceImpl implements OfficeFileService {

    @Override
    public List<Map<String, Object>> readExcelData(String filePath) {
        ExcelReader reader = ExcelUtil.getReader(filePath);
        return reader.readAll();
    }
}
