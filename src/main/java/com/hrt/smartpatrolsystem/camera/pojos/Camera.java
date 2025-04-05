package com.hrt.smartpatrolsystem.camera.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hrt.smartpatrolsystem.common.annotation.IpAddress;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Camera
 * Package: com.hrt.smartpatrolsystem.camera.pojos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 11:55
 * @Version: v1.0
 */
@Data
@TableName("camera")
public class Camera implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 摄像头名称
     */
    @TableField("name")
    private String name;

    /**
     * 摄像头位置
     */
    @TableField("location")
    private String location;

    /**
     * 摄像头ip地址
     */
    @NotBlank
    @IpAddress
    @TableField("ip_address")
    private String ipAddress;

    /**
     * 摄像头状态
     * 0-正常
     * 1-停止使用
     * 2-故障
     */
    @TableField("status")
    private Short status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
}
