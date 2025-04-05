package com.hrt.smartpatrolsystem.report.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.ShortTypeHandler;

import java.util.Date;

/**
 * ClassName: EquipmentFaultReport
 * Package: com.hrt.smartpatrolsystem.report.pojos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/4 - 18:35
 * @Version: v1.0
 */
@Data
@TableName("equipment_fault_report")
public class EquipmentFaultReport {
    /*
    * 报修单id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /*
    * 报修时间
     */
    @TableField("report_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportDate;

    /*
    * 报修设备id
     */
    @TableField("damage_device_id")
    private Long damageDeviceId;

    /*
    * 报修类型
    * 0-画面丢失
    * 1-信号中断
    * 2-硬件故障
    * 3-其它
     */
    @TableField("fault_type")
    private Short faultType;

    /*
    * 报修描述
     */
    @TableField("description")
    private String description;

    /*
    * 报修状态
    * 0-未处理
    * 1-处理中
    * 2-已修复
     */
    @TableField("status")
    private Short status;

    /*
    * 报修区域
     */
    @TableField("related_area")
    private String relatedArea;

    /*
    * 操作人员id
     */
    @TableField("operator_id")
    private Long operatorId;

    /*
    * 报表类型id
     */
    @TableField("type_id")
    private Integer typeId;

    /*
    * 是否删除
    * 0-未删除
    * 1-已删除
     */
    @TableField(value = "is_deleted")
    private Short isDeleted;

    /*
    * 创建时间
     */
    @TableField("created_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /*
    * 更新时间
     */
    @TableField("updated_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
}
