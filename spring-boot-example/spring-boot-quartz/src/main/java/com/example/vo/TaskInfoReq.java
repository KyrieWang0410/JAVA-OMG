package com.example.vo;

import lombok.Data;

/**
 * @author Kyrie.Wang
 */
@Data
public class TaskInfoReq {
    /** 任务编号 */
    private Integer id;
    /** 任务时间表达式 */
    private String cron;
    /** 任务状态 */
    private String status;
    /** 任务名称 */
    private String jobName;
    /** 每页显示条数 */
    private Integer pageSize = 10;
    /** 当前页数 */
    private Integer pageCurrent = 1;
}
