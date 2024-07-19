package com.example.service;

import com.example.common.Result;
import com.example.entity.TaskInfo;
import com.example.vo.TaskInfoReq;

import java.util.List;

/**
 * @author Kyrie.Wang
 */
public interface TaskInfoService {

    /** 获取任务列表分页 */
    Result selectTaskListByPage(TaskInfoReq taskInfoReq);

    /** 添加定时任务 */
    Result addJob(TaskInfoReq taskInfoReq);

    /** 更新任务 */
    Result updateJob(TaskInfoReq taskInfoReq);

    /** 暂停任务 */
    Result pauseJob(Integer taskId);

    /** 恢复任务 */
    Result resumeJob(Integer taskId);

    /** 获取所有任务 */
    List<TaskInfo> selectTasks();

    /** 删除任务 */
    Result delete(TaskInfoReq reqVo);
}
