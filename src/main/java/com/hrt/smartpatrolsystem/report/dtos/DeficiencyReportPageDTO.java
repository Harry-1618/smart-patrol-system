package com.hrt.smartpatrolsystem.report.dtos;

import com.hrt.smartpatrolsystem.common.dtos.PageRequestDto;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: DeficiencyReportDTO
 * Package: com.hrt.smartpatrolsystem.report.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 17:39
 * @Version: v1.0
 */
@Data
public class DeficiencyReportPageDTO extends PageRequestDto {
    private Integer typeId;
    private Date startTime;
    private Date endTime;
}
