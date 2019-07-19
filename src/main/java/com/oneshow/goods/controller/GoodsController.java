package com.oneshow.goods.controller;


import com.oneshow.commom.util.R;
import com.oneshow.goods.entity.Goods;
import com.oneshow.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/add")
    public R add(@RequestBody Goods goods){
        goodsService.save(goods);
        return R.ok();
    }
}

