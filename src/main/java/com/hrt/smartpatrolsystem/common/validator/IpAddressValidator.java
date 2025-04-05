package com.hrt.smartpatrolsystem.common.validator;

import com.hrt.smartpatrolsystem.common.annotation.IpAddress;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


/**
 * ClassName: IpAddressValidator
 * Package: com.hrt.smartpatrolsystem.common.validator
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/5 - 12:53
 * @Version: v1.0
 */
public class IpAddressValidator implements ConstraintValidator<IpAddress, String> {

    //ip地址的正则表达式
    private static final String IPV4_PATTERN =
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null)
            return false;
        return s.matches(IPV4_PATTERN);
    }
}
