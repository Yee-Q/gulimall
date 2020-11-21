package com.zk.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.common.utils.PageUtils;
import com.zk.gulimall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 18:04:55
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

