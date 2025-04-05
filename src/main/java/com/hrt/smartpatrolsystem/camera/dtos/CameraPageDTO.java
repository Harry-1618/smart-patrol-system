package com.hrt.smartpatrolsystem.camera.dtos;

import com.hrt.smartpatrolsystem.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * ClassName: CameraPageDTO
 * Package: com.hrt.smartpatrolsystem.camera.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 13:21
 * @Version: v1.0
 */
@Data
public class CameraPageDTO extends PageRequestDto {
    private String name;
    private String location;
}
