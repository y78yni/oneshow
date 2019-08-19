package com.oneshow.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oneshow.commom.util.R;
import com.oneshow.commom.util.ValidatorUtils;
import com.oneshow.framework.util.ShiroUtils;
import com.oneshow.shop.entity.Goods;
import com.oneshow.shop.service.GoodsService;
import com.oneshow.user.entity.User;
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
 * @since 2019-07-11
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "添加商品")
    @PostMapping("/save")
    @ResponseBody
    public R save(@RequestBody Goods goods){
        ValidatorUtils.validateEntity(goods);
        goodsService.add(goods);
        return R.ok();
    }

    @ApiOperation(value = "删除商品")
    @PostMapping("/delete")
    @ResponseBody
    public R delete(@RequestBody Integer[] ids){
        goodsService.deleteBatch(ids);
        return R.ok();
    }

    @ApiOperation(value = "修改商品")
    @PostMapping("/update")
    @ResponseBody
    public R update(@RequestBody Goods goods){
        ValidatorUtils.validateEntity(goods);
        goodsService.update(goods);
        return R.ok();
    }
    @ApiOperation(value = "查看商品")
    @PostMapping("/info/{id}")
    @ResponseBody
    public R info(Integer id){
        Goods goods =goodsService.queryObject(id);
        return R.ok().put("goods",goods);
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
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        if(title != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("goods_name",title);
        }
        Page<Goods> goodsPage = new Page<>(pageIndex, pageSize);
        IPage<Goods> goodsList = goodsService.getGoodsAll(goodsPage,qw);
        int total = goodsService.queryTotal(qw);
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
        r.put("goodsList",goodsList);
        return R.ok(r);
    }

    /**
     * 商品回收站列表
     *
     * @return
     */
    @ApiOperation(value = "商品回收站")
    @ResponseBody
    @GetMapping("/historyList")
    public R historyList(String title,Integer pageIndex,Integer pageSize) {
        //查询列表数据
        User user = ShiroUtils.getUser();
        if (pageIndex == null ||pageIndex < 0){
            pageIndex=1;
        }
        if(pageSize == null ||pageSize < 0){
            pageSize=10;
        }
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("publish_status",0);
        if(title != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("goods_name",title);
        }
        if(user.getUserName() != "admin"){
            qw.eq("id",user.getId());
        }
        Page<Goods> GoodsPage = new Page<>(pageIndex, pageSize);
        IPage<Goods> goodsList = goodsService.getGoodsAll(GoodsPage,qw);
        int total = goodsService.queryTotal(qw);
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
        r.put("goodsList",goodsList);
        return R.ok(r);
    }

    /**
     * 商品从回收站恢复
     */
    @ApiOperation(value = "商品从回收站恢复")
    @ResponseBody
    @PostMapping("/back")
    public R back(@RequestBody Integer[] ids) {
        goodsService.back(ids);
        return R.ok();
    }

    /**
     * 上架
     */
    @ApiOperation(value = "上架")
    @ResponseBody
    @PostMapping("/enSale")
    public R enSale(@RequestBody Integer id) {
        goodsService.enSale(id);
        return R.ok();
    }

    /**
     * 下架
     */
    @ApiOperation(value = "下架")
    @ResponseBody
    @PostMapping("/unSale")
    public R unSale(@RequestBody Integer id) {
        goodsService.unSale(id);
        return R.ok();
    }
}

