package com.zk.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.common.utils.PageUtils;
import com.zk.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 13:00:28
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

