package com.hrt.smartpatrolsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrt.smartpatrolsystem.camera.pojos.Camera;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: CameraMapper
 * Package: com.hrt.smartpatrolsystem.mapper
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 13:16
 * @Version: v1.0
 */
@Mapper
public interface CameraMapper extends BaseMapper<Camera> {

    @Select("select * from camera")
    public List<Camera> getCameraList();
}
