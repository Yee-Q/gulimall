package com.zk.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.common.utils.PageUtils;
import com.zk.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 13:00:28
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

