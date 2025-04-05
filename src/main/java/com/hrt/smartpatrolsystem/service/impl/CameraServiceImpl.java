package com.hrt.smartpatrolsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.smartpatrolsystem.camera.dtos.CameraDTO;
import com.hrt.smartpatrolsystem.camera.dtos.CameraPageDTO;
import com.hrt.smartpatrolsystem.camera.dtos.CameraStatusDTO;
import com.hrt.smartpatrolsystem.camera.pojos.Camera;
import com.hrt.smartpatrolsystem.camera.pojos.OperationLog;
import com.hrt.smartpatrolsystem.camera.vos.CameraStatusVO;
import com.hrt.smartpatrolsystem.camera.vos.CameraVO;
import com.hrt.smartpatrolsystem.common.vos.PageResponseResult;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.mapper.CameraMapper;
import com.hrt.smartpatrolsystem.service.ICameraService;
import com.hrt.smartpatrolsystem.service.IOperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: CameraServiceImpl
 * Package: com.hrt.smartpatrolsystem.service.impl
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 13:15
 * @Version: v1.0
 */
@Service
@Slf4j
@Transactional
public class CameraServiceImpl extends ServiceImpl<CameraMapper, Camera> implements ICameraService {
    @Autowired
    private CameraMapper cameraMapper;

    @Autowired
    private IOperationLogService operationLogService;
    //获取摄像头列表
    @Override
    public ResponseResult getCameraList() {
        List<Camera> cameraList = cameraMapper.getCameraList();
        if (cameraList != null)
            return ResponseResult.okResult(cameraList);
        return ResponseResult.errorResult(HttpCodeEnum.ERROR);
    }

    //分页查询摄像头列表
    @Override
    public ResponseResult getCameraPageResult(CameraPageDTO dto) {
        if(dto == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        dto.checkParam();
        IPage<Camera> page=new Page(dto.getPage(),dto.getPageSize());
        page = page(page, Wrappers.<Camera>lambdaQuery()
                .eq(dto.getName() != null, Camera::getName, dto.getName())
                .eq(dto.getLocation() != null, Camera::getLocation, dto.getLocation())
        );
        List<CameraVO> list = page.getRecords().stream().map(this::convertToCameraVO).collect(Collectors.toList());
        ResponseResult responseResult=new PageResponseResult(list.size());
        responseResult.setData(list);
        responseResult.setCode(HttpCodeEnum.SUCCESS.getCode());
        responseResult.setMsg(HttpCodeEnum.SUCCESS.getMsg());
        return responseResult;
    }


    //根据id查询摄像头
    @Override
    public ResponseResult getCameraById(Integer id) {
        Camera camera = getById(id);
        if (camera == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        return ResponseResult.okResult(camera);
    }

    //更新摄像头状态
    @Override
    public ResponseResult updateCameraStatus(CameraStatusDTO cameraStatusDTO) {
        if (cameraStatusDTO == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        if (update(Wrappers.<Camera>lambdaUpdate()
                .eq(Camera::getId, cameraStatusDTO.getCamera_id())
                .set(Camera::getStatus, cameraStatusDTO.getOperation())))
        {
            OperationLog operationLog = new OperationLog();
            operationLog.setOperatorId(cameraStatusDTO.getOperator_id()==null?null:cameraStatusDTO.getOperator_id().intValue());
            operationLog.setOperationType(Short.valueOf((short) 0));
            operationLog.setCameraId(cameraStatusDTO.getCamera_id());
            operationLog.setRemarks("更新摄像头状态");
            operationLogService.save(operationLog);
        }
        CameraStatusVO cameraStatusVO = new CameraStatusVO();
        cameraStatusVO.setCameraId(cameraStatusDTO.getCamera_id());
        cameraStatusVO.setStatus(cameraStatusDTO.getOperation());
        return ResponseResult.okResult(cameraStatusVO);
    }

    //添加摄像头
    @Override
    public ResponseResult addCamera(CameraDTO cameraDTO) {
        if (cameraDTO == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        Camera camera = new Camera();
        BeanUtils.copyProperties(cameraDTO, camera, Camera.class);
        if (save(camera))
            return ResponseResult.okResult(null);
        return ResponseResult.errorResult(HttpCodeEnum.ERROR);
    }

    //更新摄像头
    @Override
    public ResponseResult updateCamera(CameraDTO cameraDTO) {
        if (cameraDTO == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        Camera oldCamera = getById(cameraDTO.getId());
        if (oldCamera != null) {
            BeanUtils.copyProperties(cameraDTO, oldCamera, Camera.class);
        }
        if (updateById(oldCamera))
            return ResponseResult.okResult(null);
        return ResponseResult.errorResult(HttpCodeEnum.ERROR);
    }

    private CameraVO convertToCameraVO(Camera camera) {
        CameraVO cameraVO = new CameraVO();
        BeanUtils.copyProperties(camera, cameraVO, CameraVO.class);
        return cameraVO;
    }
}
