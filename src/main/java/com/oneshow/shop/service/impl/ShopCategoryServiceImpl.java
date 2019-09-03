package com.oneshow.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.commom.exception.SBException;
import com.oneshow.shop.entity.ShopCategory;
import com.oneshow.shop.mapper.ShopCategoryMapper;
import com.oneshow.shop.service.ShopCategoryService;
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
@Service("ShopCategoryService")
public class ShopCategoryServiceImpl extends ServiceImpl<ShopCategoryMapper, ShopCategory> implements ShopCategoryService {
    @Resource
    private  ShopCategoryMapper shopCategoryMapper;
    @Override
    public int add(ShopCategory shopCategory) {
        QueryWrapper<ShopCategory> qw = new QueryWrapper<>();
        qw.eq("name",shopCategory.getName());
        List<ShopCategory> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("分类名称已存在");
        }
        return shopCategoryMapper.insert(shopCategory);
    }

    @Override
    public int delete(Integer id) {
        return shopCategoryMapper.deleteById(id);
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
    public int update(ShopCategory shopCategory) {
        QueryWrapper<ShopCategory> qw = new QueryWrapper<>();
        qw.eq("name",shopCategory.getName());
        List<ShopCategory> list = list(qw);
        if (null != list && list.size() != 0) {
            throw new SBException("分类名称已存在");
        }
        return shopCategoryMapper.updateById(shopCategory);
    }

    @Override
    public ShopCategory queryObject(Integer id) {
        return shopCategoryMapper.selectById(id);
    }

    @Override
    public IPage<ShopCategory> getAll(String key, PageModel pageModel) {
        QueryWrapper<ShopCategory> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        Page<ShopCategory> shopCategoryPage = new Page<>(pageModel.getPageIndex(), pageModel.getPageSize());
        IPage<ShopCategory> shopCategoryList = shopCategoryMapper.selectPage(shopCategoryPage,qw);
        return shopCategoryList;
    }

    @Override
    public int queryTotal(String key) {
        QueryWrapper<ShopCategory> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        return shopCategoryMapper.selectCount(qw);
    }

    @Override
    public List<ShopCategory> getListALl(String key) {
        QueryWrapper<ShopCategory> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        return shopCategoryMapper.selectList(qw);
    }

}
