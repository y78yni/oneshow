package com.oneshow.user.entity.Form;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户登录对象")
public class LoginForm {

	@ApiModelProperty(name = "loginName", value = "登录名", dataType = "String", required = true)
	@NotBlank(message = "登录名不能为空")
	private String loginName;

	@ApiModelProperty(name = "passWord", value = "密码", dataType = "String", required = true)
	@NotBlank(message = "密码不能为空")
	private String passWord;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
