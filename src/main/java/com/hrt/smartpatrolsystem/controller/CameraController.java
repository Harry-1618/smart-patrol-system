package com.hrt.smartpatrolsystem.controller;

import com.hrt.smartpatrolsystem.camera.dtos.CameraPageDTO;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BulkBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: CameraController
 * Package: com.hrt.smartpatrolsystem.controller
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 13:14
 * @Version: v1.0
 */
@RestController
@RequestMapping("/cameras")
public class CameraController {

    @Autowired
    private ICameraService cameraService;
    @GetMapping
    public ResponseResult getCameraList(){
        return cameraService.getCameraList() ;
    }

    @GetMapping("/pages")
    public ResponseResult getCameraPageResult(@RequestBody CameraPageDTO cameraPageDTO){
        return cameraService.getCameraPageResult(cameraPageDTO) ;
    }
}
