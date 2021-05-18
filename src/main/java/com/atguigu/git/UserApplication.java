package com.atguigu.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@SpringBootApplication
@RestController
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }

    //1.要检验的参数前，加上@Valid注解
    //2.紧随其后的，跟上一个BindingResult来存储检验信息
    @RequestMapping("/test1")
    public Object test1(@Valid User user, BindingResult bindingResult){
        //如果检验出了问题，就返回错误信息
        //这里我们返回的是全部的错误信息，实际中可根据bindingResult的方法根据需要返回自定义的信息。
        //通常的解决方案为：JSR-303 + 全局ExceptionHandler
        //System.out.println(bindingResult.hasErrors());
        System.out.println(user.getName() + ":" + user.getAge());
        if (bindingResult.hasErrors()){
            return bindingResult.getAllErrors();
        }
        return "OK";
    }
}
