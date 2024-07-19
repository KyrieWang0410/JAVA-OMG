package com.example.task;

import cn.hutool.extra.spring.SpringUtil;
import com.example.entity.TaskInfo;
import com.example.vo.TaskInfoReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Component;

/**
 * 任务管理器，主要接收业务指令，来完成对 Quartz 容器进行操作
 * <p>
 * 1、添加任务 2、更新任务 3、暂停任务 4、恢复任务
 *
 * @author Kyrie.Wang
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class TaskManager {
    public static final String JOB_DEFAULT_GROUP_NAME = "JOB_DEFAULT_GROUP_NAME";
    public static final String TRIGGER_DEFAULT_GROUP_NAME = "TRIGGER_DEFAULT_GROUP_NAME";

    private final Scheduler scheduler;

    /**
     * 添加任务
     */
    public boolean addJob(TaskInfoReq taskInfoReq) {
        boolean flag = true;
        if (!CronExpression.isValidExpression(taskInfoReq.getCron())) {
            log.error("定时任务表达式有误：{}", taskInfoReq.getCron());
            return false;
        }
        try {
            JobDetail jobDetail = JobBuilder.newJob().withIdentity(new JobKey(taskInfoReq.getJobName(), JOB_DEFAULT_GROUP_NAME))
                    .ofType((Class<? extends Job>) SpringUtil.getBean(taskInfoReq.getJobName()).getClass())
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withSchedule(CronScheduleBuilder.cronSchedule(taskInfoReq.getCron()))
                    .withIdentity(new TriggerKey(taskInfoReq.getJobName(), TRIGGER_DEFAULT_GROUP_NAME))
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (Exception e) {
            log.error("添加定时任务异常：{}", e.getMessage(), e);
            flag = false;
        }
        return flag;
    }

    /**
     * 更新任务
     */
    public boolean updateJob(TaskInfo taskInfo) {
        boolean flag = true;
        try {
            JobKey jobKey = new JobKey(taskInfo.getJobName(), JOB_DEFAULT_GROUP_NAME);
            TriggerKey triggerKey = new TriggerKey(taskInfo.getJobName(), TRIGGER_DEFAULT_GROUP_NAME);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (scheduler.checkExists(jobKey) && scheduler.checkExists(triggerKey)) {
                Trigger newTrigger = TriggerBuilder.newTrigger()
                        .forJob(jobDetail)
                        .withSchedule(CronScheduleBuilder.cronSchedule(taskInfo.getCron()))
                        .withIdentity(triggerKey)
                        .build();
                scheduler.rescheduleJob(triggerKey, newTrigger);
            } else {
                log.info("更新任务失败，任务不存在，任务名称：{}，表达式：{}", taskInfo.getJobName(), taskInfo.getCron());
            }
            log.info("更新任务成功，任务名称：{}，表达式：{}", taskInfo.getJobName(), taskInfo.getCron());
        } catch (SchedulerException e) {
            log.error("更新定时任务失败:{}", e.getMessage(), e);
            flag = false;
        }
        return flag;
    }


    /**
     * 暂停任务
     */
    public boolean pauseJob(TaskInfo taskInfo) {
        try {
            scheduler.pauseJob(JobKey.jobKey(taskInfo.getJobName(), JOB_DEFAULT_GROUP_NAME));
            log.info("任务暂停成功：{}", taskInfo.getId());
            return true;
        } catch (SchedulerException e) {
            log.error("暂停定时任务失败:{}", e.getMessage(), e);
            return false;
        }
    }


    /**
     * 恢复任务
     */
    public boolean resumeJob(TaskInfo taskInfo) {
        try {
            scheduler.resumeJob(JobKey.jobKey(taskInfo.getJobName(), JOB_DEFAULT_GROUP_NAME));
            log.info("任务恢复成功：{}", taskInfo.getId());
            return true;
        } catch (SchedulerException e) {
            log.error("恢复定时任务失败:{}", e.getMessage(), e);
            return false;
        }
    }

}
