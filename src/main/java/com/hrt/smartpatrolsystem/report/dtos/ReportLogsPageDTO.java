package com.hrt.smartpatrolsystem.report.dtos;

import com.hrt.smartpatrolsystem.common.dtos.PageRequestDto;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: ReportLogsDTO
 * Package: com.hrt.smartpatrolsystem.report.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 11:19
 * @Version: v1.0
 */
@Data
public class ReportLogsPageDTO extends PageRequestDto {
    private Integer typeId;
    private Date startTime;
    private Date endTime;
}
