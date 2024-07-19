package com.example;

import com.example.entity.TaskInfo;
import com.example.service.TaskInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@Slf4j
public class QuartzAppTest {

    @Resource
    TaskInfoService taskInfoService;

    @Test
    public void run1() {
        List<TaskInfo> taskInfos = taskInfoService.selectTasks();
        log.info("taskInfos:{}", taskInfos);
    }
}
