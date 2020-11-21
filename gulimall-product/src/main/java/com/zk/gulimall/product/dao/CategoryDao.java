package com.zk.gulimall.product.dao;

import com.zk.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 13:00:28
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
