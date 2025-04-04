package com.hrt.smartpatrolsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.smartpatrolsystem.common.vos.PageResponseResult;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.mapper.DeficiencyReportMapper;
import com.hrt.smartpatrolsystem.report.dtos.ReportLogsPageDTO;
import com.hrt.smartpatrolsystem.report.pojos.DeficiencyReport;

import com.hrt.smartpatrolsystem.report.pojos.ReportType;
import com.hrt.smartpatrolsystem.report.vos.DeficiencyReportVO;

import com.hrt.smartpatrolsystem.service.IDeficiencyReportService;
import com.hrt.smartpatrolsystem.service.IReportTypeService;
import com.hrt.smartpatrolsystem.service.IUserService;
import com.hrt.smartpatrolsystem.user.pojos.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: DeficiencyReportServiceImpl
 * Package: com.hrt.smartpatrolsystem.service.impl
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 17:52
 * @Version: v1.0
 */
@Service
@Slf4j
@Transactional
public class DeficiencyReportServiceImpl extends ServiceImpl<DeficiencyReportMapper, DeficiencyReport> implements IDeficiencyReportService {
    /**
     * 获取所有缺陷报告
     * @param dto
     * @return
     */
    @Override
    public ResponseResult getDeficiencyReportsList(ReportLogsPageDTO dto) {
        if (dto == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        dto.checkParam();
        IPage<DeficiencyReport> page=new Page(dto.getPage(),dto.getPageSize());
        page = page(page, Wrappers.<DeficiencyReport>lambdaQuery()
                .eq(dto.getTypeId() != null, DeficiencyReport::getTypeId, dto.getTypeId())
                .ge(dto.getStartTime() != null, DeficiencyReport::getReportDate, dto.getStartTime())
                .le(dto.getEndTime() != null,DeficiencyReport::getReportDate, dto.getEndTime())
        );

        List<DeficiencyReportVO> list = page.getRecords().stream()
                .map(this::convertToDeficiencyReportVO)
                .toList();

        ResponseResult responseResult=new PageResponseResult(list.size());
        responseResult.setData(list);
        responseResult.setCode(HttpCodeEnum.SUCCESS.getCode());
        return responseResult;
    }

    @Autowired
    private IUserService userService;

    @Autowired
    private IReportTypeService reportTypeService;

    private DeficiencyReportVO convertToDeficiencyReportVO(DeficiencyReport deficiencyReport) {
        DeficiencyReportVO deficiencyReportVO = new DeficiencyReportVO();
        BeanUtils.copyProperties(deficiencyReport, deficiencyReportVO, DeficiencyReportVO.class);
        deficiencyReportVO.setTypeName(reportTypeService.getById(deficiencyReport.getTypeId()).getTypeName());

        // 设置审核人名称
        deficiencyReportVO.setAuditorName(
                Optional.ofNullable(userService.getById(deficiencyReport.getAuditorId()))
                        .map(User::getName)
                        .orElse("未知用户")
        );
        return deficiencyReportVO;
    }
}
