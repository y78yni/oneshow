package com.oneshow.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.shop.entity.ShopCategory;
import com.oneshow.shop.entity.ShopChannel;
import com.oneshow.shop.mapper.ShopChannelMapper;
import com.oneshow.shop.service.ShopChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ShopChannelServiceImpl extends ServiceImpl<ShopChannelMapper, ShopChannel> implements ShopChannelService {

    @Resource
    private ShopChannelMapper shopChannelMapper;

    @Override
    public int add(ShopChannel shopChannel) {
        return shopChannelMapper.insert(shopChannel);
    }

    @Override
    public int delete(Integer id) {
        return shopChannelMapper.deleteById(id);
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
    public int update(ShopChannel shopChannel) {
        return shopChannelMapper.updateById(shopChannel);
    }

    @Override
    public ShopChannel queryObject(Integer id) {
        return shopChannelMapper.selectById(id);
    }

    @Override
    public IPage<ShopChannel> getAll(String key, PageModel pageModel) {
        QueryWrapper<ShopChannel> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        Page<ShopChannel> shopChannelPage = new Page<>(pageModel.getPageIndex(), pageModel.getPageSize());
        IPage<ShopChannel> shopChannelList = shopChannelMapper.selectPage(shopChannelPage,qw);
        return shopChannelList;
    }

    @Override
    public int queryTotal(String key) {
        QueryWrapper<ShopChannel> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        return shopChannelMapper.selectCount(qw);
    }

    @Override
    public List<ShopChannel> getListALl(String key) {
        QueryWrapper<ShopChannel> qw = new QueryWrapper<>();
        if(key != null){
            //暂时使用标题模糊搜索，需要更多搜索在这里构造条件
            qw.like("name",key);
        }
        return shopChannelMapper.selectList(qw);
    }
}
