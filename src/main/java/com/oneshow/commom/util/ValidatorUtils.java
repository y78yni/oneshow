package com.oneshow.commom.util;

import com.oneshow.commom.exception.SBException;
import com.oneshow.commom.exception.SystemErrorCode;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws SBException  校验不通过，则报RRException异常
     */
    public static void validateEntity(Object object, Class<?>... groups) throws SBException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> con = (ConstraintViolation<Object>)constraintViolations.iterator().next();
            throw new SBException(SystemErrorCode.ILLEGAL_PARAMETER,con.getMessage());
        }
    }
}
