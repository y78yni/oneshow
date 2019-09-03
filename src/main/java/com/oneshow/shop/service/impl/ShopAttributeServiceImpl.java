package com.oneshow.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.commom.exception.SBException;
import com.oneshow.shop.entity.ShopAttribute;
import com.oneshow.shop.mapper.ShopAttributeMapper;
import com.oneshow.shop.service.ShopAttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-08-16
 */
@Service("ShopAttributeService")
public class ShopAttributeServiceImpl extends ServiceImpl<ShopAttributeMapper, ShopAttribute> implements ShopAttributeService {
    @Resource
    private  ShopAttributeMapper shopAttributeMapper;
    @Override
    public int add(ShopAttribute shopAttribute) {
        QueryWrapper<ShopAttribute> qw = new QueryWrapper<>();
        qw.eq("name",shopAttribute.getName());
        List<ShopAttribute> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("属性名称已存在");
        }
        return shopAttributeMapper.insert(shopAttribute);
    }

    @Override
    public int delete(Integer id) {
        return shopAttributeMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result += delete(id);
        }
        return result;
    }

    @Override
    public int update(ShopAttribute shopAttribute) {
        QueryWrapper<ShopAttribute> qw = new QueryWrapper<>();
        qw.eq("name",shopAttribute.getName());
        List<ShopAttribute> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("属性名称已存在");
        }
        return shopAttributeMapper.updateById(shopAttribute);
    }

    @Override
    public ShopAttribute queryObject(Integer id) {
        return shopAttributeMapper.selectById(id);
    }

    @Override
    public IPage<ShopAttribute> getAll(String key, PageModel pageModel) {
        QueryWrapper<ShopAttribute> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        Page<ShopAttribute> shopAttributePage = new Page<>(pageModel.getPageIndex(), pageModel.getPageSize());
        IPage<ShopAttribute> shopAttributeList = shopAttributeMapper.selectPage(shopAttributePage,qw);

        return shopAttributeList;
    }

    @Override
    public int queryTotal(String key) {
        QueryWrapper<ShopAttribute> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        return shopAttributeMapper.selectCount(qw);
    }
}
