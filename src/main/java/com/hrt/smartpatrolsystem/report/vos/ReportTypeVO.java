package com.hrt.smartpatrolsystem.report.vos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: ReportTypeVO
 * Package: com.hrt.smartpatrolsystem.report.vos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/3 - 15:25
 * @Version: v1.0
 */
@Data
public class ReportTypeVO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type_name")
    private String typeName;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("created_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
}
