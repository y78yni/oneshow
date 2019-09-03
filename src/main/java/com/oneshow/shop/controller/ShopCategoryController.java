package com.oneshow.shop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.commom.util.R;
import com.oneshow.commom.util.ValidatorUtils;
import com.oneshow.shop.entity.ShopCategory;
import com.oneshow.shop.service.ShopCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/shopCategory")
public class ShopCategoryController {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @ApiOperation(value = "添加分类")
    @RequestMapping("/save")
    @ResponseBody
    public R save(@RequestBody ShopCategory shopCategory) {
        ValidatorUtils.validateEntity(shopCategory);
        shopCategoryService.add(shopCategory);
        return  R.ok();
    }
    @ApiOperation(value = "删除分类")
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(@RequestBody Integer[] ids) {
        shopCategoryService.deleteBatch(ids);
        return  R.ok();
    }
    @ApiOperation(value = "修改分类")
    @RequestMapping("/update")
    @ResponseBody
    public R update(@RequestBody ShopCategory shopCatesgory) {
        shopCategoryService.update(shopCatesgory);
        return  R.ok();
    }
    @ApiOperation(value = "查看分类")
    @RequestMapping("/info/{id}")
    @ResponseBody
    public R info(Integer id) {
        ShopCategory shopCategory = shopCategoryService.queryObject(id );
        return  R.ok().put("shopCategory",shopCategory);
    }
    @ApiOperation(value = "查看分页列表")
    @RequestMapping("/list")
    @ResponseBody
    public R list(String key, PageModel pageModel) {
        IPage<ShopCategory> shopCategoryList = shopCategoryService.getAll(key,pageModel);
        int shopCategoryCount = shopCategoryService.queryTotal(key);
        R r = new R();
        r.put("pageIndex",pageModel.getPageIndex());
        r.put("pageSize",pageModel.getPageSize());
        r.put("shopCategoryCount",shopCategoryCount);
        r.put("shopCategoryList",shopCategoryList);
        return R.ok(r);
    }
    @ApiOperation(value = "查看所有列表")
    @RequestMapping("/listAll")
    @ResponseBody
    public R listAll(String key) {
        List<ShopCategory> shopCategoryList = shopCategoryService.getListALl(key);
        //添加顶级菜单
        ShopCategory root = new ShopCategory();
        root.setId(0);
        root.setName("一级分类");
        root.setParentId(-1);
        //root.set(true);
        shopCategoryList.add(0,root);
        return R.ok().put("shopCategoryList",shopCategoryList);
    }
}

