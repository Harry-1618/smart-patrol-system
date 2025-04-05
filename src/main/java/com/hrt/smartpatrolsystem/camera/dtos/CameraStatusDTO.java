package com.hrt.smartpatrolsystem.camera.dtos;

import lombok.Data;

/**
 * ClassName: CameraStatusDTO
 * Package: com.hrt.smartpatrolsystem.camera.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 14:01
 * @Version: v1.0
 */
@Data
public class CameraStatusDTO {
    private Integer camera_id;
    //0-正常运行，1-停止运行,2-故障
    private Short operation;
    private Long operator_id;
}
