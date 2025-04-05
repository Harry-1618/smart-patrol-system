package com.hrt.smartpatrolsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.smartpatrolsystem.camera.pojos.OperationLog;
import com.hrt.smartpatrolsystem.mapper.OperationLogMapper;
import com.hrt.smartpatrolsystem.service.IOperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: OperationLogServiceImpl
 * Package: com.hrt.smartpatrolsystem.service.impl
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 14:23
 * @Version: v1.0
 */
@Service
@Slf4j
@Transactional
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {
}
