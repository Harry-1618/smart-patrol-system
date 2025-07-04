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
 * ClassName: ReportType
 * Package: com.hrt.smartpatrolsystem.report.pojos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/3 - 14:44
 * @Version: v1.0
 */
@Data
@TableName("report_type")
public class ReportType implements Serializable {
    //主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //类型名称
    @TableField("type_name")
    private String typeName;

    //创建时间
    @TableField("created_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    //更新时间
    @TableField("updated_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    //备注
    @TableField("remark")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String remark;
}
