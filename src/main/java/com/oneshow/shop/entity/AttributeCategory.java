package com.oneshow.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jun
 * @since 2019-08-15
 */
@ApiModel(value = "属性分类对象", description = "新增&更新属性分类对象")
public class AttributeCategory extends Model<AttributeCategory> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotBlank(message = "属性分类名称不能为空")
    @ApiModelProperty(name = "name", value = "属性分类名", dataType = "String", required = true)
    private String name;

    /**
     * 1开启; 0关闭;
     */
    @NotBlank(message = "属性分类名称不能为空")
    @ApiModelProperty(name = "name", value = "属性分类开关（1.开启：0关闭）", dataType = "String", required = true)
    private Integer enabled;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AttributeCategory{" +
        "id=" + id +
        ", name=" + name +
        ", enabled=" + enabled +
        "}";
    }
}
