package com.oneshow.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.oneshow.user.constants.UserConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

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
    @NotBlank(message = "昵称不能为空")
    private String userName;

    /**
     * 手机
     */
    @NotBlank(message = "手机不能为空")
    @Pattern(regexp = UserConstants.MOBILE_PHONE_NUMBER_PATTERN, message = "手机格式不正确")
    private String mobile;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除（0=正常，1=删除s）
     */
    private Integer status;

    /**
     * 登录名
     */
    @NotBlank(message = "用户名不能为空")
    private String loginName;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = UserConstants.EMAIL_PATTERN, message = "邮箱格式不正确")
    private String email;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String userPassword;

}