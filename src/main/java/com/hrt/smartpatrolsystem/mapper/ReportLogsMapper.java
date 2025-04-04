package com.hrt.smartpatrolsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrt.smartpatrolsystem.report.pojos.ReturnLogReport;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: ReportLogsMapper
 * Package: com.hrt.smartpatrolsystem.mapper
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 11:24
 * @Version: v1.0
 */
@Mapper
public interface ReportLogsMapper extends BaseMapper<ReturnLogReport> {
}
