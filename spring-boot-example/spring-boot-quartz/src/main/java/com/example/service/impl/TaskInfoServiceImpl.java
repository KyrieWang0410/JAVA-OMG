package com.example.service.impl;

import com.example.common.Result;
import com.example.dao.TaskInfoDao;
import com.example.entity.TaskInfo;
import com.example.service.TaskInfoService;
import com.example.task.TaskManager;
import com.example.vo.TaskInfoReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Kyrie.Wang
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskInfoServiceImpl implements TaskInfoService {


    private final TaskInfoDao taskInfoDao;

    private final TaskManager taskManager;


    @Override
    public Result selectTaskListByPage(TaskInfoReq taskInfoReq) {
        /*PageHelper.startPage(taskInfoReq.getPageCurrent(), taskInfoReq.getPageSize());
        List<TaskInfo> list = taskInfoDao.selectTaskInfos(taskInfoReq);
        PageInfo<TaskInfo> pageInfo = new PageInfo<>(list);
        return ResponseFactory.build(pageInfo);*/
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateJob(TaskInfoReq taskInfoReq) {
        /*
        if (!CronExpression.isValidExpression(taskInfoReq.getCron())) {
            log.error("更新任务失败，表达式有误：{}", taskInfoReq.getCron());
            return ResponseFactory.build(CodeMsg.TASK_CRON_ERROR);
        }
        TaskInfo isExistData = taskInfoDao.selectByJobName(taskInfoReq.getJobName());
        //当任务存在，则更改失败
        if ((!Objects.isNull(isExistData)) && (!isExistData.getId().equals(taskInfoReq.getId()))) {
            return ResponseFactory.build(CodeMsg.TASK_CRON_DOUBLE);
        }
        TaskInfo data = taskInfoDao.selectByPrimaryKey(taskInfoReq.getId());
        if (data == null) {
            return ResponseFactory.build(CodeMsg.TASK_NOT_EXITES);
        }


        BeanUtils.copyProperties(taskInfoReq, data);
        data.setUpdateTime(LocalDateTime.now());
        taskInfoDao.updateByPrimaryKeySelective(data);


        if (!taskManager.updateJob(data)) {
            return ResponseFactory.build(CodeMsg.TASK_EXCEPTION);
        }
        return ResponseFactory.build();
        */
        return null;
    }


    @Override
    public Result pauseJob(Integer taskId) {
       /* TaskInfo data = taskInfoDao.selectByPrimaryKey(taskId);
        if (data == null) {
            return ResponseFactory.build(CodeMsg.TASK_NOT_EXITES);
        }
        if (!taskManager.pauseJob(data)) {
            return ResponseFactory.build(CodeMsg.TASK_EXCEPTION);
        }
        data.setStatus(EnumTaskEnable.STOP.getCode());
        taskInfoDao.updateByPrimaryKeySelective(data);
        return ResponseFactory.build();*/
        return null;
    }


    @Override
    public Result resumeJob(Integer taskId) {
        /*TaskInfo data = taskInfoDao.selectByPrimaryKey(taskId);
        if (data == null) {
            return ResponseFactory.build(CodeMsg.TASK_NOT_EXITES);
        }
        if (!taskManager.resumeJob(data)) {
            return ResponseFactory.build(CodeMsg.TASK_EXCEPTION);
        }
        data.setStatus(EnumTaskEnable.START.getCode());
        taskInfoDao.updateByPrimaryKeySelective(data);
        return ResponseFactory.build();*/
        return null;
    }


    @Override
    public Result addJob(TaskInfoReq taskInfoReq) {
        /*if (!taskManager.addJob(taskInfoReq)) {
            return ResponseFactory.build(CodeMsg.TASK_EXCEPTION);
        }
        TaskInfo data = taskInfoDao.selectByJobName(taskInfoReq.getJobName());
        //当任务不存在，则返回成功插入
        if (Objects.isNull(data)) {
            data = new TaskInfo();
            BeanUtils.copyProperties(taskInfoReq, data);
            data.setCreateTime(LocalDateTime.now());
            taskInfoDao.insertSelective(data);
            return ResponseFactory.build();
        } else {
            return ResponseFactory.build(CodeMsg.TASK_CRON_DOUBLE);
        }*/

        return null;
    }


    @Override
    public Result delete(TaskInfoReq reqVo) {
       /* try {
            //TODO 删除任务只是做了暂停，如果是 Quartz Jdbc 模式下添加重复任务可能加不进去，并没有真正删除(可自行调整)
            Result result = this.pauseJob(reqVo.getId());
            //只有暂停成功的任务才能删除
            if (CodeMsg.SUCCESS == result.getCode()) {
                taskInfoDao.deleteByPrimaryKey(reqVo.getId());
                return ResponseFactory.build();
            } else {
                return ResponseFactory.build(CodeMsg.TASK_EXCEPTION);
            }
        } catch (Exception e) {
            return ResponseFactory.build(CodeMsg.TASK_EXCEPTION);
        }*/
        return null;
    }

    @Override
    public List<TaskInfo> selectTasks() {
        /*return taskInfoDao.selectAll();*/
        return null;
    }

}
