package com.hrt.smartpatrolsystem.report.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: DeficiencyReport
 * Package: com.hrt.smartpatrolsystem.report.pojos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 17:29
 * @Version: v1.0
 */
@Data
@TableName("deficiency_report")
public class DeficiencyReport implements Serializable {
    /*
    主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /*
    缺额日期
     */
    @TableField("report_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportDate;

    /*
    缺额人id
     */
    @TableField("person_id")
    private Long personId;

    /*
    缺额原因
     */
    @TableField("deficiency_reason")
    private String deficiencyReason;

    /*
    缺额审核状态
     0：未审核(默认)
     1：已审核
     2：审核不通过
     */
    @TableField("audit_status")
    private Short auditStatus;

    /*
    缺额审核人id
     */
    @TableField("auditor_id")
    private Long auditorId;

    /*
    报表类型id
     */
    @TableField("type_id")
    private Short typeId;

    /*
    备注
     */
    @TableField("remark")
    private String remark;

    /*
    是否删除
     0：未删除
     1：已删除
     */
    @TableField("is_deleted")
    private Short isDeleted;

    /*
    创建时间
     */
    @TableField("created_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /*
    更新时间
     */
    @TableField("updated_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

}
