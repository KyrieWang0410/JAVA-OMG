package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Kyrie.Wang
 */
@Data
public class TaskInfo implements Serializable {
    private Integer id;
    private String cron;
    private String jobName;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
