package com.example.common;

import java.util.HashMap;
import java.util.Map;


/**
 * 公共返回码
 *
 * @author Kyrie.Wang
 */
public class CodeMsg {


    //系统
    public static final int SUCCESS = 200;
    public static final int ERROR = 500;
    //任务
    public static final int TASK_NOT_EXITES = 100001;
    public static final int TASK_EXCEPTION = 100002;
    public static final int TASK_CRON_ERROR = 100003;
    public static final int TASK_CRON_DOUBLE = 100004;
    private static final Map<Integer,String> MSG = new HashMap<Integer,String>();

    static {
        //系统
        MSG.put(SUCCESS, "请求成功.");
        MSG.put(ERROR, "服务器异常.");


        //任务
        MSG.put(TASK_NOT_EXITES, "定时任务不存在");
        MSG.put(TASK_EXCEPTION, "设置定时任务失败");
        MSG.put(TASK_CRON_ERROR, "表达式有误");
        MSG.put(TASK_CRON_DOUBLE, "定时任务已经存在");
    }



    public static String getMsg(int errcode) {
        return MSG.get(errcode);
    }
}
