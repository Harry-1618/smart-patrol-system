package com.hrt.smartpatrolsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.report.dtos.ReportTypeDTO;
import com.hrt.smartpatrolsystem.report.pojos.ReportType;

/**
 * ClassName: IReportService
 * Package: com.hrt.smartpatrolsystem.service
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/3 - 14:50
 * @Version: v1.0
 */
public interface IReportTypeService extends IService<ReportType> {

    /*
    * @Description: 获取所有报告类型
     */
    public ResponseResult getReportTypeList();

    /*
    * @Description: 添加报告类型
     */
    ResponseResult addReportType(ReportTypeDTO reportTypeDTO);
}
