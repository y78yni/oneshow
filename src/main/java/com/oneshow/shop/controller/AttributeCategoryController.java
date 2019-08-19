package com.oneshow.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oneshow.commom.util.R;
import com.oneshow.commom.util.ValidatorUtils;
import com.oneshow.shop.entity.AttributeCategory;
import com.oneshow.shop.service.AttributeCategoryService;
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
 * @since 2019-08-15
 */
@Controller
@RequestMapping("/attributeCategory")
public class AttributeCategoryController {
    @Autowired
    private AttributeCategoryService attributeCategoryService;

    @ApiOperation(value = "添加分类")
    @PostMapping("/save")
    @ResponseBody
    public R save(@RequestBody AttributeCategory attributeCategory){
        ValidatorUtils.validateEntity(attributeCategory);
        attributeCategoryService.add(attributeCategory);
        return R.ok();
    }
    @ApiOperation(value = "删除分类")
    @PostMapping("/delete")
    @ResponseBody
    public R delete(@RequestBody Integer[] ids){
        attributeCategoryService.deleteBatch(ids);
        return R.ok();
    }
    @ApiOperation(value = "修改分类")
    @PostMapping("/update")
    @ResponseBody
    public R update(@RequestBody AttributeCategory attributeCategory){
        attributeCategoryService.update(attributeCategory);
        return R.ok();
    }
    @ApiOperation(value = "查看分类")
    @PostMapping("/info/{id}")
    @ResponseBody
    public R info(Integer id){
        AttributeCategory attributeCategory = attributeCategoryService.queryObject(id);
        return R.ok().put("attributeCategory",attributeCategory);
    }
    /**
     * 查看列表
     */
    @ApiOperation(value = "查看列表")
    @ResponseBody
    @GetMapping( "/list")
    public R list(String title,Integer pageIndex,Integer pageSize) {
        if (pageIndex == null ||pageIndex < 0){
            pageIndex=1;
        }
        if(pageSize == null ||pageSize < 0){
            pageSize=10;
        }
        QueryWrapper<AttributeCategory> qw = new QueryWrapper<>();
        if(title != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",title);
        }
        Page<AttributeCategory> page = new Page<>(pageIndex, pageSize);
        IPage<AttributeCategory> list = attributeCategoryService.getAll(page,qw);
        int total = attributeCategoryService.queryTotal(qw);
        int totalPage = (int) Math.ceil((double)total/pageSize);
        if (totalPage < 1) {
            totalPage = 1;
        }
        if (pageIndex > totalPage) {
            pageIndex = totalPage;
        }
        R r = new R();
        r.put("pageIndex",pageIndex);
        r.put("pageSize",pageSize);
        r.put("total",total);
        r.put("goodsList",list);
        return R.ok(r);
    }
}

