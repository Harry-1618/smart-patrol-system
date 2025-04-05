package com.hrt.smartpatrolsystem.camera.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * ClassName: CameraStatusVO
 * Package: com.hrt.smartpatrolsystem.camera.vos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 14:31
 * @Version: v1.0
 */
@Data
public class CameraStatusVO {

    @JsonProperty("camera_id")
    private Integer cameraId;

    @JsonProperty("status")
    private Short status;
}
