package com.demo;

import com.demo.service.OfficeFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class OfficeFileServiceTest {
    private final OfficeFileService officeFileService;

    @Test
    void readExcelData() throws Exception {
        String filePath = "F:\\test\\test_template_file.xls";
        List<Map<String, Object>> maps = officeFileService.readExcelData(filePath);
        maps.forEach(map -> log.info("map: {}", map));
    }
}
