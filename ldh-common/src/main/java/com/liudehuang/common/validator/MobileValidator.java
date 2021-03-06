package com.liudehuang.common.validator;

import com.liudehuang.common.annotation.IsMobile;
import com.liudehuang.common.constants.RegexpConstant;
import com.liudehuang.common.utils.LdhUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return LdhUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}