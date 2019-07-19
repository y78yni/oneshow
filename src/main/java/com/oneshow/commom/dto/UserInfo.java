package com.oneshow.commom.dto;

import com.oneshow.user.entity.User;

import java.io.Serializable;

public class UserInfo extends User implements Serializable {
    private RoleInfo roleInfo;

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
}
