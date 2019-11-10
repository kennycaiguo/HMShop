package com.shop.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.PageResponseEntity;
import com.shop.item.bo.SpuBo;
import com.shop.item.entities.BrandEntity;
import com.shop.item.entities.SpuEntity;
import com.shop.item.mapper.BrandMapper;
import com.shop.item.mapper.CategoryMapper;
import com.shop.item.mapper.SpuDetailMapper;
import com.shop.item.mapper.SpuMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GoodsService {

    @Resource
    private SpuMapper mSpuMapper;

    @Resource
    private BrandMapper mBrandMapper;

    @Resource
    private CategoryService mCategoryService;

    @Resource
    private SpuDetailMapper mSpuDetailMapper;


    public PageResponseEntity<SpuBo> querySpuByPage(String key, String saleable, Integer page, Integer rows) {
        Example example = new Example(SpuEntity.class);
        Example.Criteria criteria = example.createCriteria();

        // 模糊查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("title", "%" + key + "%");
        }

        // 上下架过滤条件
        if (saleable != null) {
            criteria.andEqualTo("saleable", saleable);
        }

        // 分页
        PageHelper.startPage(page, rows);
        List<SpuEntity> spuEntities = mSpuMapper.selectByExample(example);

        // 查询
        Stream<SpuBo> spuBoStream = spuEntities.stream().map(spu -> {
            // 品牌信息
            BrandEntity brandEntity = mBrandMapper.selectByPrimaryKey(spu.getBrandId());

            // 分类信息
            List<String> categoryNames = mCategoryService.queryNamesByIds(Arrays.asList(spu.getCategoryId1(), spu.getCategoryId2(), spu.getCategoryId3()));

            return SpuBo.builder().build();
        });

        // 返回信息
        PageInfo<SpuEntity> spuPageInfo = new PageInfo<>(spuEntities);
        return PageResponseEntity.create(spuPageInfo.getPageNum(), spuPageInfo.getPages(), spuBoStream.collect(Collectors.toList()));
    }
}
