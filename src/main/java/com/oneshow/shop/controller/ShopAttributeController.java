package com.oneshow.shop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.commom.util.R;
import com.oneshow.commom.util.ValidatorUtils;
import com.oneshow.shop.entity.ShopAttribute;
import com.oneshow.shop.service.ShopAttributeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jun
 * @since 2019-08-16
 */
@Controller
@RequestMapping("/shopAttribute")
public class ShopAttributeController {
    @Autowired
    private ShopAttributeService shopAttributeService;

    @ApiOperation(value = "添加商品属性")
    @RequestMapping("/save")
    @ResponseBody
    public R save(@RequestBody ShopAttribute shopAttribute) {
        ValidatorUtils.validateEntity(shopAttribute);
        shopAttributeService.add(shopAttribute);
        return  R.ok();
    }
    @ApiOperation(value = "删除商品属性")
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(@RequestBody Integer[] ids) {
        shopAttributeService.deleteBatch(ids);
        return  R.ok();
    }
    @ApiOperation(value = "修改商品属性")
    @PostMapping("/update")
    @ResponseBody
    public  R update(@RequestBody ShopAttribute shopAttribute ){
        shopAttributeService.update(shopAttribute);
        return  R.ok();
    }
    @ApiOperation(value = "商品属性详细")
    @RequestMapping("/info/{id}")
    @ResponseBody
    public  R detail(Integer id){
        shopAttributeService.queryObject(id);
        return  R.ok();
    }
    /**
     * 查看列表
     */
    @ApiOperation(value = "查看列表")
    @ResponseBody
    @RequestMapping( "/list")
    public R list(String key, PageModel pageModel) {
        IPage<ShopAttribute> shopAttributes = shopAttributeService.getAll(key,pageModel);
        int shopAttributeCount = shopAttributeService.queryTotal(key);
        R r = new R();
        r.put("pageIndex",pageModel.getPageIndex());
        r.put("pageSize",pageModel.getPageSize());
        r.put("shopAttributeCount",shopAttributeCount);
        r.put("shopAttributes",shopAttributes);
        return R.ok(r);
    }
}

