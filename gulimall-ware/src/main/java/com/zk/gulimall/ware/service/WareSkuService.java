package com.zk.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.common.utils.PageUtils;
import com.zk.gulimall.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 18:24:05
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

