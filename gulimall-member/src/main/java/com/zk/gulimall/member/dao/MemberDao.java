package com.zk.gulimall.member.dao;

import com.zk.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author yeeq
 * @email 1051195623@qq.com
 * @date 2020-11-15 18:11:53
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
