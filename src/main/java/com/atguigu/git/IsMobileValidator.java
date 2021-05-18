package com.atguigu.git;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//自定义注解一定要实现ConstraintValidator接口，泛型里面的两个参数
//第一个为具体要校验的注解
//第二个为 校验的参数类型
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required = false;

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    //工具方法，判断是否是手机号
    public static boolean isMobile(String src){
        if(StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        System.out.println("执行initialize");
        required = constraintAnnotation.isRequired();

    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("执行isValid");
        //是否为手机号的实现
        if(required){
            return isMobile(phone);
        }else{
            if (StringUtils.isEmpty(phone)){
                return true;
            }else{
                return isMobile(phone);
            }
        }
    }
}
