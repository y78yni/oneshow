//package com.jun.oneshow.util;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Validator;
//
//import javax.validation.ConstraintViolation;
//import java.util.Iterator;
//import java.util.Optional;
//import java.util.Set;
//
//@Component
//public class ValidatorUtils  implements ApplicationContextAware {
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        ValidatorUtils.validator = (Validator) applicationContext.getBean("validator");
//    }
//
//    private static Validator validator;
//
//    public static Optional<String> validateResultProcess(Object obj)  {
//        Set<ConstraintViolation<Object>> results = validator.validate(obj);
//        if (CollectionUtils.isEmpty(results)) {
//            return Optional.empty();
//        }
//        StringBuilder sb = new StringBuilder();
//
//        for (Iterator<ConstraintViolation<Object>> iterator = results.iterator(); iterator.hasNext(); ) {
//            sb.append(iterator.next().getMessage());
//            if (iterator.hasNext()) {
//                sb.append(" ,");
//            }
//        }
//        return Optional.of(sb.toString());
//    }
//}
