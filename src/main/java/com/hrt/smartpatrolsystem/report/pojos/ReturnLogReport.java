package com.hrt.smartpatrolsystem.report.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: ReportLogs
 * Package: com.hrt.smartpatrolsystem.report.pojos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 11:25
 * @Version: v1.0
 */
@Data
@TableName("return_log_report")
public class ReturnLogReport implements Serializable {
    /*
    * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /*
    * 返回日期
     */
    @TableField("report_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportDate;

    /*
    * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /*
    * 开始时间
     */
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /*
    * 结束时间
     */
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /*
    * 返回次数
     */
    @TableField("return_count")
    private Short returnCount;

    /*
    * 返回时长
     */
    @TableField("duration")
    private String duration;

    /*
    * 状态
    * 0-已完成
    * 1-正在进行中
    * 2-未开始
    * 3-异常
     */
    @TableField("status")
    private Short status;

    /*
    * 路径
     */
    @TableField("path")
    private String path;

    /*
    * 类型id
     */
    @TableField("type_id")
    private Integer typeId;

    /*
    * 是否删除
    * 0-未删除
    * 1-已删除
     */
    @TableField("is_deleted")
    private Short isDeleted;

    /*
    * 创建时间
     */
    @TableField("created_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /*
    * 更新时间
     */
    @TableField("updated_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
}
