package com.hrt.smartpatrolsystem.report.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
public class ReportType {
    //主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //类型名称
    @TableField("type_name")
    private String typeName;

    //创建时间
    @TableField("created_time")
    private Date createdTime;

    //更新时间
    @TableField("updated_time")
    private Date updatedTime;

    //备注
    @TableField("remark")
    private String remark;
}
