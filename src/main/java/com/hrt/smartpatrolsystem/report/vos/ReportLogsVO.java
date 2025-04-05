package com.hrt.smartpatrolsystem.report.vos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: ReportLogsVO
 * Package: com.hrt.smartpatrolsystem.report.vos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 11:47
 * @Version: v1.0
 */
@Data
public class ReportLogsVO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("report_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportDate;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("status")
    private Short status;

    @JsonProperty("path")
    private String path;

    @JsonProperty("type_name")
    private String typeName;
}
