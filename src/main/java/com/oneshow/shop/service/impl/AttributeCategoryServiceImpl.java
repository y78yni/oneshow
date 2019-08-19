package com.oneshow.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oneshow.commom.exception.SBException;
import com.oneshow.shop.entity.AttributeCategory;
import com.oneshow.shop.mapper.AttributeCategoryMapper;
import com.oneshow.shop.service.AttributeCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jun
 * @since 2019-08-15
 */
@Service
public class AttributeCategoryServiceImpl extends ServiceImpl<AttributeCategoryMapper, AttributeCategory> implements AttributeCategoryService {
    @Resource
    private AttributeCategoryMapper attributeCategoryMapper;

    @Override
    public int add(AttributeCategory attributeCategory) {
        QueryWrapper<AttributeCategory> qw = new QueryWrapper<>();
        qw.eq("name",attributeCategory.getName());
        List<AttributeCategory> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("属性名称已存在");
        }
        return attributeCategoryMapper.insert(attributeCategory);
    }

    @Override
    public int delete(Integer id) {
        return attributeCategoryMapper.deleteById(id);
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
    public int update(AttributeCategory attributeCategory) {
        QueryWrapper<AttributeCategory> qw = new QueryWrapper<>();
        qw.eq("goods_name",attributeCategory.getName());
        List<AttributeCategory> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("属性名称已存在");
        }
        return attributeCategoryMapper.updateById(attributeCategory);
    }

    @Override
    public AttributeCategory queryObject(Integer id) {
        return attributeCategoryMapper.selectById(id);
    }

    @Override
    public IPage<AttributeCategory> getAll(IPage<AttributeCategory> page, Wrapper<AttributeCategory> queryWrapper) {
        return attributeCategoryMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int queryTotal(Wrapper<AttributeCategory> queryWrapper) {
        return attributeCategoryMapper.selectCount(queryWrapper);
    }
}
