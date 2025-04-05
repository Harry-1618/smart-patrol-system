package com.hrt.smartpatrolsystem.camera.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: OperationLog
 * Package: com.hrt.smartpatrolsystem.camera.pojos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 14:04
 * @Version: v1.0
 */
@Data
@TableName("operation_log")
public class OperationLog implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作类型
     */
    @TableField("operation_type")
    private Short operationType;

    /**
     * 操作时间
     */
    @TableField("operation_time")
    private Date operationTime;

    /**
     * 操作人id
     */
    @TableField("operator_id")
    private Integer operatorId;

    /**
     * 操作摄像头id
     */
    @TableField("camera_id")
    private Integer cameraId;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
