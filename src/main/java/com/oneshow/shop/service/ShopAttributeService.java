package com.oneshow.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oneshow.commom.Model.PageModel;
import com.oneshow.shop.entity.ShopAttribute;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Jun
 * @since 2019-08-16
 */
@Service
public interface ShopAttributeService extends IService<ShopAttribute> {
    /**
     * 保存实体
     *
     * @return 保存条数
     */
    int add(ShopAttribute shopAttribute);

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
    int update(ShopAttribute shopAttribute);

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ShopAttribute queryObject(Integer id);

    /**
     * 分页查询
     *
     * @return list
     */
    IPage<ShopAttribute> getAll(String key, PageModel pageModel);

    /**
     * 分页统计总数
     *
     * @return 总数
     */
    int queryTotal(String key);
}
