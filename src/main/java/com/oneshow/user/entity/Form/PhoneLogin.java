package com.oneshow.user.entity.Form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "手机登录对象")
public class PhoneLogin {
    @ApiModelProperty(name = "phone", value = "手机", dataType = "String", required = true)
    @NotBlank(message = "手机不能为空")
    private  String phone;

    @ApiModelProperty(name = "code", value = "验证码", dataType = "String", required = true)
    @NotNull(message = "验证码不能为空")
    private  String code;
}
