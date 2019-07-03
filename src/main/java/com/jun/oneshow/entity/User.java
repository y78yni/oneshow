package com.jun.oneshow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.jun.oneshow.constants.UserConstants;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jun
 * @since 2019-07-03
 */
@Data
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名(昵称)
     */
    private String userName;

    /**
     * 手机
     */
    @NotNull(message = "手机不能为空")
    //@Pattern(regexp = UserConstants.MOBILE_PHONE_NUMBER_PATTERN, message = "手机格式不正确")
    private Integer mobile;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除（0=正常，1=删除s）
     */
    private Integer status;

    /**
     * 登录名
     */
    @NotNull(message = "用户名不能为空")
    private String loginName;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空")
    @Pattern(regexp = UserConstants.EMAIL_PATTERN, message = "邮箱格式不正确")
    private String email;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String userPassword;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}