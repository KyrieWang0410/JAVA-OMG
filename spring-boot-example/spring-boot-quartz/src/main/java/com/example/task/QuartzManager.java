package com.example.task;


import com.example.common.EnumTaskEnable;
import com.example.entity.TaskInfo;
import com.example.service.TaskInfoService;
import com.example.vo.TaskInfoReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Kyrie.Wang
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class QuartzManager {


    private final Scheduler scheduler;
    private final SpringJobFactory springJobFactory;
    private final TaskInfoService taskInfoService;


    @PostConstruct
    public void start() {
        //启动所有任务
        try {
            scheduler.setJobFactory(springJobFactory);
            // scheduler.clear();
            List<TaskInfo> tasks = taskInfoService.selectTasks();
            for (TaskInfo taskInfo : tasks) {
                if (EnumTaskEnable.START.getCode().equals(taskInfo.getStatus()) && !StringUtils.isEmpty(taskInfo.getCron())) {
                    TaskInfoReq data = new TaskInfoReq();
                    BeanUtils.copyProperties(taskInfo, data);
                    taskInfoService.addJob(data);
                }
            }
            log.info("定时任务启动完成");
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("定时任务初始化失败");
        }
    }
}
