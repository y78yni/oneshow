package com.oneshow.shop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.commom.util.R;
import com.oneshow.commom.util.ValidatorUtils;
import com.oneshow.shop.entity.ShopCategory;
import com.oneshow.shop.entity.ShopChannel;
import com.oneshow.shop.service.ShopChannelService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jun
 * @since 2019-08-15
 */
@Controller
@RequestMapping("/shopChannel")
public class ShopChannelController {
    @Autowired
    private ShopChannelService shopChannelService;

    @ApiOperation(value = "添加")
    @RequestMapping("/save")
    @ResponseBody
    public R save(@RequestBody ShopChannel shopChannel) {
        ValidatorUtils.validateEntity(shopChannel);
        shopChannelService.add(shopChannel);
        return  R.ok();
    }
    @ApiOperation(value = "删除")
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(@RequestBody Integer[] ids) {
        shopChannelService.deleteBatch(ids);
        return  R.ok();
    }
    @ApiOperation(value = "修改")
    @RequestMapping("/update")
    @ResponseBody
    public R update(@RequestBody ShopChannel shopChannel) {
        shopChannelService.update(shopChannel);
        return  R.ok();
    }
    @ApiOperation(value = "查看")
    @RequestMapping("/info/{id}")
    @ResponseBody
    @RequiresPermissions("channel:info")
    public R info(Integer id) {
        ShopChannel shopChannel = shopChannelService.queryObject(id );
        return  R.ok().put("shopCategory",shopChannel);
    }
    @ApiOperation(value = "查看分页列表")
    @RequestMapping("/list")
    @ResponseBody
    public R list(String key, PageModel pageModel) {
        IPage<ShopChannel> shopChannelList = shopChannelService.getAll(key,pageModel);
        int shopChannelCount = shopChannelService.queryTotal(key);
        R r = new R();
        r.put("pageIndex",pageModel.getPageIndex());
        r.put("pageSize",pageModel.getPageSize());
        r.put("shopCategoryCount",shopChannelCount);
        r.put("shopCategoryPageList",shopChannelList);
        return R.ok(r);
    }
    @ApiOperation(value = "查看所有列表")
    @RequestMapping("/listAll")
    @ResponseBody
    public R listAll(String key) {
        List<ShopChannel> shopChannelist = shopChannelService.getListALl(key);
        return R.ok().put("shopCategoryList",shopChannelist);
    }
}

