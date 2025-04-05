package com.hrt.smartpatrolsystem.controller;

import com.hrt.smartpatrolsystem.camera.dtos.CameraDTO;
import com.hrt.smartpatrolsystem.camera.dtos.CameraPageDTO;
import com.hrt.smartpatrolsystem.camera.dtos.CameraStatusDTO;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BulkBean;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseResult getCameraById(@PathVariable Integer id){
        return cameraService.getCameraById(id);
    }

    @PutMapping("/status")
    public ResponseResult updateCameraStatus(@RequestBody CameraStatusDTO cameraStatusDTO){
        return cameraService.updateCameraStatus(cameraStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseResult removeCameraById(@PathVariable Integer id){
        return cameraService.removeById(id) ? ResponseResult.okResult(HttpCodeEnum.SUCCESS) : ResponseResult.errorResult(HttpCodeEnum.ERROR);
    }

    @PostMapping
    public ResponseResult addCamera(@RequestBody CameraDTO cameraDTO){
        return cameraService.addCamera(cameraDTO);
    }

    @PutMapping
    public ResponseResult updateCamera(@RequestBody CameraDTO cameraDTO){
        return cameraService.updateCamera(cameraDTO);
    }
}
