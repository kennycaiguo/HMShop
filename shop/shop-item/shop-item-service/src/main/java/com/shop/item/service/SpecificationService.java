package com.shop.item.service;

import com.shop.item.entities.SpecGroupEntity;
import com.shop.item.entities.SpecParamEntity;
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

    /**
     * 根据分组查询参数
     */
    public List<SpecGroupEntity> queryGroupsByCategoryId(Long id) {
        return this.mSpecGroupMapper.select(new SpecGroupEntity(id));
    }


    /**
     * 查询参数
     */
    public List<SpecParamEntity> queryParams(Long id, Long groupId, Boolean generic, Boolean searching) {
        return mSpecParamMapper.select(SpecParamEntity.builder()
                .id(id)
                .groupId(groupId)
                .generic(generic)
                .searching(searching)
                .build()
        );
    }

    /**
     * 添加参数
     */
    public void addParams(SpecParamEntity specParam) {
        mSpecParamMapper.insert(specParam);
    }
}
