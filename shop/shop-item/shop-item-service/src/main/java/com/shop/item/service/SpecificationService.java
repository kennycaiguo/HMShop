package com.shop.item.service;

import com.shop.item.entities.SpecGroupEntity;
import com.shop.item.mapper.SpecGroupMapper;
import com.shop.item.mapper.SpecParamMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationService {

    @Resource
    private SpecParamMapper mSpecParamMapper;

    @Resource
    private SpecGroupMapper mSpecGroupMapper;

    public List<SpecGroupEntity> queryGroupsByCategoryId(Long id) {
        return this.mSpecGroupMapper.select(new SpecGroupEntity(id));
    }
}
