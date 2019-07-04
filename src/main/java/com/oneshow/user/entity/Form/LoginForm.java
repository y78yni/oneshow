package com.oneshow.user.entity.Form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {
    @NotBlank(message = "登录名不能为空")
    private  String email;
    @NotBlank(message = "密码不能为空")
    private  String passWord;
}
