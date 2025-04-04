package com.hrt.smartpatrolsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.mapper.ReportTypeMapper;
import com.hrt.smartpatrolsystem.report.dtos.ReportTypeDTO;
import com.hrt.smartpatrolsystem.report.pojos.ReportType;
import com.hrt.smartpatrolsystem.report.vos.ReportTypeVO;
import com.hrt.smartpatrolsystem.service.IReportTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: ReportTypeServiceImpl
 * Package: com.hrt.smartpatrolsystem.service.impl
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/3 - 14:51
 * @Version: v1.0
 */
@Service
@Slf4j
@Transactional
public class ReportTypeServiceImpl extends ServiceImpl<ReportTypeMapper, ReportType> implements IReportTypeService {

    @Autowired
    private ReportTypeMapper reportTypeMapper;

    /*
    * @Description: 获取所有报告类型
     */
    @Override
    public ResponseResult getReportTypeList() {
        List<ReportType> reportTypeList = reportTypeMapper.getReportTypeList();
        if (reportTypeList == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        List<ReportTypeVO> collect = reportTypeList.stream().map(this::convertToReportTypeVO).collect(Collectors.toList());
        return ResponseResult.okResult(collect);
    }

    /*
     * @Description: 添加报告类型
     */

    @Override
    public ResponseResult addReportType(ReportTypeDTO reportTypeDTO) {
        if (reportTypeDTO == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        ReportType reportType = new ReportType();
        BeanUtils.copyProperties(reportTypeDTO, reportType, ReportType.class);
        reportType.setCreatedTime(new Date());
        reportType.setUpdatedTime(new Date());
        save(reportType);
        return ResponseResult.okResult(null);
    }

    /**
     * @Description: 将ReportType对象转换为ReportTypeVO对象
     */
    private ReportTypeVO convertToReportTypeVO(ReportType reportType) {
        ReportTypeVO reportTypeVO=new ReportTypeVO();
        BeanUtils.copyProperties(reportType, reportTypeVO, ReportTypeVO.class);
        return reportTypeVO;
    }
}
