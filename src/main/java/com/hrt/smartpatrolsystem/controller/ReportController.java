package com.hrt.smartpatrolsystem.controller;

import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.report.dtos.ReportTypeDTO;
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

    @GetMapping("/report-types")
    ResponseResult getReportType(){
        return reportTypeService.getReportTypeList();
    }

    @PostMapping("/report-types")
    ResponseResult addReportType(@RequestBody ReportTypeDTO reportTypeDTO){
        return reportTypeService.addReportType(reportTypeDTO);
    }
}
