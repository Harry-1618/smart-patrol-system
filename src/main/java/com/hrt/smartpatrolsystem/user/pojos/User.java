package com.hrt.smartpatrolsystem.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: User
 * Package: com.hrt.smartpatrolsystem.pojos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/28 - 17:20
 * @Version: v1.0
 */
@Data
@TableName("user")
public class User{

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 邮箱
     */
    @TableField("email")
    @Email
    private String email;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 状态
     * 0-禁用
     * 1-正常
     * 2-锁定
     */
    @TableField("status")
    private Short status;

    /**
     * 角色
     * 0-普通用户
     * 1-管理员
     */
    @TableField("role")
    private Short role;

    /**
     * 是否删除
     * 0-未删除
     * 1-已删除
     */
    @TableField("is_deleted")
    private Short isDeleted;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;

}
