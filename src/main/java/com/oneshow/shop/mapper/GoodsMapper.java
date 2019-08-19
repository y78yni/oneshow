package com.oneshow.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oneshow.shop.entity.Goods;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    Integer queryMaxId();
}
