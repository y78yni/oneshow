package com.oneshow.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jun
 * @since 2019-07-12
 */
@ApiModel(value = "添加&更新用户对象")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(name = "userName", value = "用户名", dataType = "String", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(name = "userPassword", value = "密码", dataType = "String", required = true)
    @NotBlank(message = "密码不能为空")
    private String userPassword;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生日

     */
    private LocalDateTime birthday;

    /**
     * 头像
     */
    private String cover;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 退出时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 退出时IP
     */
    private String lastLoginIp;

    /**
     * 创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否删除（0=正常，1=删除）
     */
    private Integer status = 0 ;

    /**
     * 昵称
     */
    private String nickName;


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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", userName=" + userName +
        ", userPassword=" + userPassword +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", cover=" + cover +
        ", mobile=" + mobile +
        ", lastLoginTime=" + lastLoginTime +
        ", lastLoginIp=" + lastLoginIp +
        ", createTime=" + createTime +
        ", email=" + email +
        ", status=" + status +
        ", nickName=" + nickName +
        "}";
    }
}
