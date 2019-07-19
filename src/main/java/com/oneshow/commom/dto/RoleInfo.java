package com.oneshow.commom.dto;

import com.oneshow.user.entity.SysMenu;
import com.oneshow.user.entity.SysRole;

import java.util.List;

public class RoleInfo extends SysRole {
    private List<SysMenu> permissions;
    public List<SysMenu> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysMenu> permissions) {
        this.permissions = permissions;
    }
}
