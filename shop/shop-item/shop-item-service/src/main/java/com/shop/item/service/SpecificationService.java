package com.shop.item.service;

import com.shop.item.entities.CategoryEntity;
import com.shop.item.entities.SpecGroupEntity;
import com.shop.item.entities.SpecParamEntity;
import com.shop.item.mapper.CategoryMapper;
import com.shop.item.mapper.SpecGroupMapper;
import com.shop.item.mapper.SpecParamMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationService {

    @Resource private CategoryMapper mCategoryMapper;

    @Resource private SpecParamMapper mSpecParamMapper;

    @Resource private SpecGroupMapper mSpecGroupMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 根据分组查询参数
     */
    public List<SpecGroupEntity> queryGroupsByCategoryId(Long id) {
        return this.mSpecGroupMapper.select(new SpecGroupEntity(id));
    }

    /**
     * 添加规模参数组
     */
    public int addSpecGroup(SpecGroupEntity params) {
        Long categoryId = params.getCategoryId();
        CategoryEntity categoryEntity = mCategoryMapper.selectByPrimaryKey(categoryId);
        if (categoryEntity == null){
            logger.info("addSpecGroup: 查询分类id失败");
            return -1;
        }

        // 添加
        return mSpecGroupMapper.insertSelective(params);
    }


    /**
     * 查询所有规格参数组
     */
    public List<SpecGroupEntity> queryGroups() {
        return mSpecGroupMapper.selectAll();
    }


    /**
     * 查询参数
     */
    public List<SpecParamEntity> queryParams(Long groupId, Long categoryId,  Boolean generic, Boolean searching) {
        return mSpecParamMapper.select(
                SpecParamEntity.builder()
                        .groupId(groupId)
                        .generic(generic)
                        .categoryId(categoryId)
                        .searching(searching)
                        .build()
        );
    }


    /**
     * 添加规格参数
     */
    public void addParams(SpecParamEntity specParam) {
        mSpecParamMapper.insert(specParam);
    }


    /**
     * 修改规格参数
     */
    public int updateParams(SpecParamEntity specParam) {
        return mSpecParamMapper.updateByPrimaryKey(specParam);
    }
}
