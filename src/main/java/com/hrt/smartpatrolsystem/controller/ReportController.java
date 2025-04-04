package com.hrt.smartpatrolsystem.controller;

import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.report.dtos.ReportLogsPageDTO;
import com.hrt.smartpatrolsystem.report.dtos.ReportTypeDTO;
import com.hrt.smartpatrolsystem.service.IDeficiencyReportService;
import com.hrt.smartpatrolsystem.service.IReportLogsService;
import com.hrt.smartpatrolsystem.service.IReportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ReportController
 * Package: com.hrt.smartpatrolsystem.controller
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/3 - 14:48
 * @Version: v1.0
 */
@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    private IReportTypeService reportTypeService;

    @Autowired
    private IReportLogsService reportLogsService;

    @Autowired
    private IDeficiencyReportService deficiencyReportService;

    @GetMapping("/report-types")
    ResponseResult getReportType(){
        return reportTypeService.getReportTypeList();
    }

    @PostMapping("/report-types")
    ResponseResult addReportType(@RequestBody ReportTypeDTO reportTypeDTO){
        return reportTypeService.addReportType(reportTypeDTO);
    }

    @GetMapping("/report-types/{id}")
    ResponseResult getReportTypeById(@PathVariable Integer id){
        return reportTypeService.getReportTypeById(id);
    }

    @GetMapping("/return-logs")
    ResponseResult getReturnLogsList(@RequestBody ReportLogsPageDTO reportLogsPageDTO){
        return reportLogsService.getReturnLogsList(reportLogsPageDTO);
    }

    @GetMapping("/deficiency-reports")
    ResponseResult getDeficiencyReportsList(@RequestBody ReportLogsPageDTO reportLogsPageDTO){
        return deficiencyReportService.getDeficiencyReportsList(reportLogsPageDTO);
    }
}
