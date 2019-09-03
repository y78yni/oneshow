package com.oneshow.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.shop.entity.ShopCategory;
import com.oneshow.shop.entity.ShopChannel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jun
 * @since 2019-08-15
 */
public interface ShopChannelService extends IService<ShopChannel> {
    /**
     * 保存实体
     *
     * @return 保存条数
     */
    int add(ShopChannel shopChannel);
    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);
    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
    /**
     * 根据主键更新实体
     *
     * @return 更新条数
     */
    int update(ShopChannel shopChannel);
    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopChannel queryObject(Integer id);

    /**
     * 分页查询
     *
     * @return list
     */
    IPage<ShopChannel> getAll(String key, PageModel pageModel);

    /**
     * 分页统计总数
     *
     * @return 总数
     */
    int queryTotal(String key);
    /**
     * 查询不分页列表
     *
     * @return list
     */
    List<ShopChannel> getListALl(String key);
}
