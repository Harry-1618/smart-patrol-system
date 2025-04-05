package com.hrt.smartpatrolsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.smartpatrolsystem.common.vos.PageResponseResult;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.mapper.ReportLogsMapper;
import com.hrt.smartpatrolsystem.report.dtos.ReportLogsPageDTO;
import com.hrt.smartpatrolsystem.report.pojos.DeficiencyReport;
import com.hrt.smartpatrolsystem.report.pojos.ReturnLogReport;
import com.hrt.smartpatrolsystem.report.vos.ReportLogsVO;
import com.hrt.smartpatrolsystem.service.IReportLogsService;
import com.hrt.smartpatrolsystem.service.IReportTypeService;
import com.hrt.smartpatrolsystem.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: IReportLogsServiceImpl
 * Package: com.hrt.smartpatrolsystem.service.impl
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 11:24
 * @Version: v1.0
 */
@Service
@Slf4j
@Transactional
public class ReportLogsServiceImpl extends ServiceImpl<ReportLogsMapper, ReturnLogReport> implements IReportLogsService {
    /**
     * 分页查询所有返岗记录
     * @param dto
     * @return
     */
    @Override
    public ResponseResult getReturnLogsList(ReportLogsPageDTO dto) {
        if (dto == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        dto.checkParam();
        IPage<ReturnLogReport> page=new Page(dto.getPage(),dto.getPageSize());
        page = page(page, Wrappers.<ReturnLogReport>lambdaQuery()
                .eq(dto.getTypeId() != null, ReturnLogReport::getTypeId, dto.getTypeId())
                .ge(dto.getStartTime() != null, ReturnLogReport::getReportDate, dto.getStartTime())
                .le(dto.getEndTime() != null,ReturnLogReport::getReportDate, dto.getEndTime())
        );
        List<ReportLogsVO> list = page.getRecords().stream()
                .map(this::convertToReportLogsVO)
                .toList();

        ResponseResult responseResult=new PageResponseResult(list.size());
        responseResult.setData(list);
        responseResult.setMsg(HttpCodeEnum.SUCCESS.getMsg());
        responseResult.setCode(HttpCodeEnum.SUCCESS.getCode());
        return responseResult;
    }


    @Autowired
    private IReportTypeService reportTypeService;

    @Autowired
    private IUserService userService;

    private ReportLogsVO convertToReportLogsVO(ReturnLogReport returnLogReport) {
        ReportLogsVO reportLogsVO = new ReportLogsVO();
        BeanUtils.copyProperties(returnLogReport, reportLogsVO, ReportLogsVO.class);
        reportLogsVO.setTypeName(reportTypeService.getById(returnLogReport.getTypeId()).getTypeName());
        reportLogsVO.setUserName(userService.getById(returnLogReport.getUserId()).getName());
        return reportLogsVO;
    }
}
