package com.shop.item.service;

import com.shop.item.mapper.CategoryMapper;
import com.shop.item.entities.CategoryEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public List<CategoryEntity> queryCategoriesByPid(Long pid) {
        return categoryMapper.select(new CategoryEntity(pid));
    }

}
