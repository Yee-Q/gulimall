package com.zk.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.common.utils.PageUtils;
import com.zk.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 13:00:28
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查出所有分类，组装成父子结构
     * @return List<CategoryEntity>
     */
    List<CategoryEntity> listWithTree();

    /**
     * 批量删除
     * @param asList 批量删除的id
     */
    void removeMenuByIds(List<Long> asList);
}

