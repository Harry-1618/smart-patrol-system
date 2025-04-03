package com.hrt.smartpatrolsystem.controller;

import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.service.IReportTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private IReportTypeService reportTypeService;

    @GetMapping("/report-type")
    ResponseResult getReportType(){
        return reportTypeService.getReportTypeList();
    }
}
