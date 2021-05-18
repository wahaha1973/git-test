package com.atguigu.git;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {

    //名字不允许为空，并且名字的长度在2到30位之间
    //如果名字的长度检验不通过，那么提示错误信息
    @NotNull
    @Size(min = 2,max = 30,message = "请检名字的长度是否有问题")
    private String name;

    //不允许为空，并且年龄的最小值为18
    @NotNull
    @Min(18)
    private Integer age;
}
