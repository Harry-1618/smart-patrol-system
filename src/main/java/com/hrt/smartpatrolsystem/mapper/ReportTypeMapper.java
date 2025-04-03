package com.hrt.smartpatrolsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrt.smartpatrolsystem.report.pojos.ReportType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: ReportTypeMapper
 * Package: com.hrt.smartpatrolsystem.mapper
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/3 - 15:10
 * @Version: v1.0
 */
@Mapper
public interface ReportTypeMapper extends BaseMapper<ReportType> {

    @Select("select * from report_type")
    public List<ReportType> getReportTypeList();
}
