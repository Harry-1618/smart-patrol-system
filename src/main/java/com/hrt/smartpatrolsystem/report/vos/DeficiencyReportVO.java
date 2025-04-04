package com.hrt.smartpatrolsystem.report.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: DeficiencyReportVO
 * Package: com.hrt.smartpatrolsystem.report.vos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 17:43
 * @Version: v1.0
 */
@Data
public class DeficiencyReportVO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("report_date")
    private Date reportDate;
    @JsonProperty("person_name")
    private String personName;
    @JsonProperty("deficiency_reason")
    private String deficiencyReason;
    @JsonProperty("audit_status")
    private Short auditStatus;
    @JsonProperty("auditor_name")
    private String auditorName;
    @JsonProperty("type_id")
    private String typeName;
}
