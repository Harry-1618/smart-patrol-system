package com.hrt.smartpatrolsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrt.smartpatrolsystem.camera.pojos.OperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OperationLogMapper
 * Package: com.hrt.smartpatrolsystem.mapper
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 14:23
 * @Version: v1.0
 */
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {
}
