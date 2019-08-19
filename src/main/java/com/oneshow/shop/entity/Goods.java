package com.oneshow.shop.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
@ApiModel(value = "商品对象", description = "新增&更新商品对象")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID=1L;

    private Integer id;

    /**
     * 商品ID

     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    @ApiModelProperty(name = "goodsName", value = "商品名", dataType = "String", required = true)
    private String goodsName;

    /**
     * 商品序列号
     */
    private String goodsSn;

    /**
     * 商品价格
     */
    @NotBlank(message = "商品价格不能为空")
    @ApiModelProperty(name = "price", value = "商品价格", dataType = "BigDecimal", required = true)
    private BigDecimal price;

    /**
     * 图片
     */
    private String goodCoverUrl;

    /**
     * 商品库存数量
     */

    private Integer number = 0;

    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述不能为空")
    @ApiModelProperty(name = "description", value = "商品描述", dataType = "String", required = true)
    private String description;

    /**
     * 销量
     */
    private Integer sale = 0;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 销售价
     */
    private BigDecimal retailPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime =LocalDateTime.now();

    /**
     * 创建人ID
     */
    private Integer createUserId;

    /**
     * 修改人ID
     */
    private Integer updateUserId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 上架状态：0->下架；1->上架
     */
    private Integer publishStatus = 0;

    /**
     * 逻辑删除(0=正常,1=删除)
     */
    private Integer status = 0;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGoodCoverUrl() {
        return goodCoverUrl;
    }

    public void setGoodCoverUrl(String goodCoverUrl) {
        this.goodCoverUrl = goodCoverUrl;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Goods{" +
        "id=" + id +
        ", goodsId=" + goodsId +
        ", goodsName=" + goodsName +
        ", goodsSn=" + goodsSn +
        ", price=" + price +
        ", goodCoverUrl=" + goodCoverUrl +
        ", number=" + number +
        ", description=" + description +
        ", sale=" + sale +
        ", marketPrice=" + marketPrice +
        ", retailPrice=" + retailPrice +
        ", createTime=" + createTime +
        ", createUserId=" + createUserId +
        ", updateUserId=" + updateUserId +
        ", updateTime=" + updateTime +
        ", publishStatus=" + publishStatus +
        ", status=" + status +
        "}";
    }
}
