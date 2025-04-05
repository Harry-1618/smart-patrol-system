package com.hrt.smartpatrolsystem.camera.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hrt.smartpatrolsystem.common.annotation.IpAddress;
import lombok.Data;

/**
 * ClassName: CameraDTO
 * Package: com.hrt.smartpatrolsystem.camera.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 14:36
 * @Version: v1.0
 */
@Data
public class CameraDTO {
    private Integer id;
    private String name;
    private String location;
    @IpAddress
    @JsonProperty("ip_address")
    private String ipAddress;
}
