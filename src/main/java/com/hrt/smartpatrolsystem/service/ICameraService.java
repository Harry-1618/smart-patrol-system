package com.hrt.smartpatrolsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hrt.smartpatrolsystem.camera.dtos.CameraDTO;
import com.hrt.smartpatrolsystem.camera.dtos.CameraPageDTO;
import com.hrt.smartpatrolsystem.camera.dtos.CameraStatusDTO;
import com.hrt.smartpatrolsystem.camera.pojos.Camera;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;

/**
 * ClassName: ICameraService
 * Package: com.hrt.smartpatrolsystem.service
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 13:15
 * @Version: v1.0
 */
public interface ICameraService extends IService<Camera> {

    /**
     * 获取摄像头列表
     * @return
     */
    ResponseResult getCameraList();

    /**
     * 分页获取摄像头列表
     * @param cameraPageDTO
     * @return
     */
    ResponseResult getCameraPageResult(CameraPageDTO cameraPageDTO);

    /**
     * 根据id获取摄像头信息
     * @param id
     * @return
     */
    ResponseResult getCameraById(Integer id);

    /**
     * 更新摄像头状态
     * @param cameraStatusDTO
     * @return
     */
    ResponseResult updateCameraStatus(CameraStatusDTO cameraStatusDTO);

    /**
     * 添加摄像头
     * @param cameraDTO
     * @return
     */
    ResponseResult addCamera(CameraDTO cameraDTO);

    /**
     * 更新摄像头
     * @param cameraDTO
     * @return
     */
    ResponseResult updateCamera(CameraDTO cameraDTO);
}
