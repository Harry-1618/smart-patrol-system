package com.hrt.smartpatrolsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.report.dtos.ReportLogsPageDTO;
import com.hrt.smartpatrolsystem.report.pojos.DeficiencyReport;

/**
 * ClassName: IDeficiencyReportService
 * Package: com.hrt.smartpatrolsystem.service
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 17:52
 * @Version: v1.0
 */
public interface IDeficiencyReportService extends IService<DeficiencyReport> {
    /*
    * @Description: 分页查询所有缺陷报告
     */
    ResponseResult getDeficiencyReportsList(ReportLogsPageDTO reportLogsPageDTO);
}
