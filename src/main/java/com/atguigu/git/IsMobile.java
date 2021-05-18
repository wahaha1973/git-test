package com.atguigu.git;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//我们可以直接拷贝系统内的注解如@Min,复制到我们新的注解中，然后根据需要修改。
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//注解的实现类
@Constraint(validatedBy = {IsMobileValidator.class})
public @interface IsMobile {

    //校验错误的信息
    String message() default "手机号码格式有问题";
    //是否强制校验
    boolean isRequired() default false;
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};
}
