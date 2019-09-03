package com.oneshow.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oneshow.shop.entity.AttributeCategory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jun
 * @since 2019-08-15
 */
@Service
public interface AttributeCategoryService extends IService<AttributeCategory> {

    /**
     * 保存实体
     *
     * @return 保存条数
     */
    int add(AttributeCategory attributeCategory);

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
    int update(AttributeCategory attributeCategory);
    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    AttributeCategory queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param page,queryWrapper 参数
     * @return list
     */
    IPage<AttributeCategory> getAll(IPage<AttributeCategory> page, Wrapper<AttributeCategory> queryWrapper);

    /**
     * 分页统计总数
     *
     * @param queryWrapper 参数
     * @return 总数
     */
    int queryTotal(Wrapper<AttributeCategory> queryWrapper);

}
