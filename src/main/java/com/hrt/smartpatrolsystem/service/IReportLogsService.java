package com.hrt.smartpatrolsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.report.dtos.ReportLogsPageDTO;
import com.hrt.smartpatrolsystem.report.pojos.ReturnLogReport;

/**
 * ClassName: IReportLogsService
 * Package: com.hrt.smartpatrolsystem.service
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 11:24
 * @Version: v1.0
 */
public interface IReportLogsService extends IService<ReturnLogReport> {
    /**
     * 分页查询所有返岗记录
     * @param reportLogsPageDTO
     * @return
     */
    ResponseResult getReturnLogsList(ReportLogsPageDTO reportLogsPageDTO);

}
