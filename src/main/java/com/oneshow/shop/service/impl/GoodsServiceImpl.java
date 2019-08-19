package com.oneshow.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oneshow.commom.exception.SBException;
import com.oneshow.framework.util.ShiroUtils;
import com.oneshow.shop.entity.Goods;
import com.oneshow.shop.mapper.GoodsMapper;
import com.oneshow.shop.service.GoodsService;
import com.oneshow.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-07-11
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public int add(Goods goods) {
        User user = ShiroUtils.getUser();
        //添加当前用户ID为商品创建人
        goods.setCreateUserId(user.getId());
        //商品名称是否能重复正在考虑，如果不能重复这里需要查询列表然后验证是否重复
        //条件构造器
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("goods_name",goods.getGoodsName());
        List<Goods> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("商品名称已存在");
        }
        return goodsMapper.insert(goods);
    }

    @Override
    public int delete(Integer id) {
        User user = ShiroUtils.getUser();
        Goods goods = getById(id);
        goods.setStatus(1);
        //修改为下架状态
        goods.setPublishStatus(0);
        goods.setUpdateUserId(user.getId());
        goods.setUpdateTime(LocalDateTime.now());
        return goodsMapper.updateById(goods);
    }

    @Override
    @Transactional
    public int deleteBatch(Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result += delete(id);
        }
        return result;
    }
    @Override
    public int update(Goods goods) {
        User user = ShiroUtils.getUser();
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("goods_name",goods.getGoodsName());
        List<Goods> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("商品名称已存在");
        }
        goods.setUpdateUserId(user.getId());
        goods.setUpdateTime(LocalDateTime.now());
        return goodsMapper.updateById(goods);
    }

    @Override
    public int back(Integer[] ids) {
        User user = ShiroUtils.getUser();
        int result = 0;
        for (Integer id : ids) {
            Goods goods = getById(id);
            goods.setStatus(0);
            //修改为上架状态
            goods.setPublishStatus(1);
            goods.setUpdateUserId(user.getId());
            goods.setUpdateTime(LocalDateTime.now());
            result += goodsMapper.updateById(goods);
        }
        return result;
    }

    @Override
    public int enSale(Integer id) {
        User user = ShiroUtils.getUser();
        Goods goods = getById(id);
        if (1 == goods.getPublishStatus()) {
            throw new SBException("此商品已处于上架状态");
        }
        goods.setPublishStatus(1);
        goods.setUpdateUserId(user.getId());
        goods.setUpdateTime(LocalDateTime.now());
        return goodsMapper.updateById(goods);
    }

    @Override
    public int unSale(Integer id) {
        User user = ShiroUtils.getUser();
        Goods goods = getById(id);
        if (0 == goods.getPublishStatus()) {
            throw new SBException("此商品已处于下架状态");
        }
        goods.setPublishStatus(0);
        goods.setUpdateUserId(user.getId());
        goods.setUpdateTime(LocalDateTime.now());
        return goodsMapper.updateById(goods);
    }

    @Override
    public Goods queryObject(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public IPage<Goods> getGoodsAll(IPage<Goods> page, Wrapper<Goods> queryWrapper) {
        return goodsMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int queryTotal(Wrapper<Goods> queryWrapper) {
        return goodsMapper.selectCount(queryWrapper);
    }
}
