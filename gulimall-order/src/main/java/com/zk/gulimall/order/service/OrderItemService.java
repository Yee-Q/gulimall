package com.zk.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.common.utils.PageUtils;
import com.zk.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 18:19:48
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

