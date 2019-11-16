package com.shop.item.service;

import com.shop.item.mapper.CategoryMapper;
import com.shop.item.entities.CategoryEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper mCategoryMapper;


    public List<CategoryEntity> queryCategoriesByPid(Long pid) {
        return mCategoryMapper.select(new CategoryEntity(pid));
    }


    public List<String> queryNamesByIds(List<Long> ids) {
        return this.mCategoryMapper.selectByIdList(ids)
                .stream()
                .map(CategoryEntity::getName)
                .collect(Collectors.toList());
    }

    public void addCategory(CategoryEntity category) {
        if (StringUtils.isNotEmpty(category.getName())) {
            mCategoryMapper.insert(category);
        }
    }
}
