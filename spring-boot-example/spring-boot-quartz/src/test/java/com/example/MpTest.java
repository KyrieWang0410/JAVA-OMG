package com.example;

import com.example.dao.TaskInfoDao;
import com.example.entity.TaskInfo;
import com.example.service.TaskInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author Kyrie.Wang
 */
@SpringBootTest
@Slf4j
public class MpTest {

    @Resource
    private TaskInfoDao taskInfoDao;

    @Resource
    private TaskInfoService taskInfoService;

    @Test
    public void testQueryList() {
        log.info(String.valueOf(Objects.isNull(taskInfoDao)));
        List<TaskInfo> taskInfos = taskInfoDao.selectList(null);
        System.out.println(taskInfos);
    }
}
