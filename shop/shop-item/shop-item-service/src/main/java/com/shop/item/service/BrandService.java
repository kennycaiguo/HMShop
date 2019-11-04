package com.shop.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.PageResponseEntity;
import com.shop.item.bo.BrandBo;
import com.shop.item.entities.CategoryBrandEntity;
import com.shop.item.mapper.BrandMapper;
import com.shop.item.mapper.CategoryBrandMapper;
import com.shop.item.entities.BrandEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandService {

    @Resource
    private BrandMapper mBrandMapper;

    @Resource
    private CategoryBrandMapper mCategoryBrandMapper;


    // 查询品牌列表
    public PageResponseEntity<BrandEntity> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        Example example = new Example(BrandEntity.class);
        Example.Criteria criteria = example.createCriteria();

        // 模糊查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        // 分页，排序
        PageHelper.startPage(page, rows);
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }

        List<BrandEntity> brands = this.mBrandMapper.selectByExample(example);
        PageInfo<BrandEntity> pageInfo = new PageInfo<>(brands);
        return PageResponseEntity.create(pageInfo.getPages(), pageInfo.getPageNum(), brands);
    }

    // 添加品牌
    @Transactional
    public void add(BrandBo brand) {
        String imagePath = brand.getImage();
        if (imagePath != null){
            // 判断图片路径是否存在于服务器
        }

        mBrandMapper.insert(new BrandEntity(brand.getName(), brand.getImage(), brand.getLetter()));
        mCategoryBrandMapper.insert(new CategoryBrandEntity(0L, brand.getCategoryId()));
    }

}
