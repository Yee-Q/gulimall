package com.zk.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.common.utils.PageUtils;
import com.zk.common.utils.Query;
import com.zk.gulimall.product.dao.CategoryDao;
import com.zk.gulimall.product.entity.CategoryEntity;
import com.zk.gulimall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 找到所有的一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0).peek(menu -> menu.setChildren(getChildren(menu, entities)))
                .sorted(Comparator.comparingInt(CategoryEntity::getSort)).collect(Collectors.toList());
        return level1Menus;

    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 递归查找所有菜单的子菜单
     * @param rootMenu 父菜单
     * @param allMenus 所有菜单
     * @return 父菜单的子菜单
     */
    private List<CategoryEntity> getChildren(CategoryEntity rootMenu, List<CategoryEntity> allMenus) {

        List<CategoryEntity> children = allMenus.stream().filter(categoryEntity ->
                categoryEntity.getParentCid().equals(rootMenu.getCatId())).collect(Collectors.toList());
        if (children.isEmpty()) {
            return null;
        } else {
            return children.stream().peek(menu -> menu.setChildren(getChildren(menu, allMenus)))
                    .sorted(Comparator.comparingInt(CategoryEntity::getSort)).collect(Collectors.toList());
        }
    }
}