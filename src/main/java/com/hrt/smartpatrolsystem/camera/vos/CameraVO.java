package com.hrt.smartpatrolsystem.camera.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hrt.smartpatrolsystem.common.annotation.IpAddress;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: CameraVO
 * Package: com.hrt.smartpatrolsystem.camera.vos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 13:23
 * @Version: v1.0
 */
@Data
public class CameraVO {
    /**
     * 主键id
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * 摄像头名称
     */
    @JsonProperty("name")
    private String name;

    /**
     * 摄像头位置
     */
    @JsonProperty("location")
    private String location;

    /**
     * 摄像头ip地址
     */
    @NotBlank
    @IpAddress
    @JsonProperty("ip_address")
    private String ipAddress;

    /**
     * 摄像头状态
     * 0-正常
     * 1-停止使用
     * 2-故障
     */
    @JsonProperty("status")
    private Short status;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
