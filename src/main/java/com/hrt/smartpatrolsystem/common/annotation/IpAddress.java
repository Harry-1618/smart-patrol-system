package com.hrt.smartpatrolsystem.common.annotation;

import com.hrt.smartpatrolsystem.common.validator.IpAddressValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * ClassName: IpAddress
 * Package: com.hrt.smartpatrolsystem.common.annotation
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 12:51
 * @Version: v1.0
 */

/**
 * 自定义IP地址校验注解
 */
@Documented
@Constraint(validatedBy = IpAddressValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IpAddress {
    String message() default "Invalid IP address";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
