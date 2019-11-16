package com.shop.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.PageResponseEntity;
import com.shop.item.bo.SpuBo;
import com.shop.item.entities.*;
import com.shop.item.mapper.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GoodsService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Resource
    private SpuMapper mSpuMapper;

    @Resource
    private BrandMapper mBrandMapper;

    @Resource
    private SkuMapper mSkuMapper;

    @Resource
    private StockMapper mStockMapper;

    @Resource
    private CategoryService mCategoryService;

    @Resource
    private SpuDetailMapper mSpuDetailMapper;

    // 分页查询spu
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

            return SpuBo.builder()
                    .spuId(spu.getId())
                    .brandId(spu.getBrandId())
                    .brandName(brandEntity.getName())
                    .categoryId1(spu.getCategoryId1())
                    .categoryId2(spu.getCategoryId2())
                    .categoryId3(spu.getCategoryId3())
                    .categoryName(StringUtils.join(categoryNames, "-"))
                    .title(spu.getTitle())
                    .subTitle(spu.getSubTitle())
                    .saleable(spu.getSaleable())
                    .valid(spu.getValid())
                    .createTime(spu.getCreateTime())
                    .lastUpdateTime(spu.getLastUpdateTime())
                    .build();
        });

        // 返回信息
        PageInfo<SpuEntity> spuPageInfo = new PageInfo<>(spuEntities);
        return PageResponseEntity.create(spuPageInfo.getPageNum(), spuPageInfo.getPages(), spuBoStream.collect(Collectors.toList()));
    }

    // 保存商品
    @Transactional
    public void addGoods(SpuBo spu) {
        logger.info("add Goods >> "+ spu.toString());

        Date date = new Date();
        SpuEntity spuEntity = SpuEntity.builder()
                .title(spu.getTitle())
                .subTitle(spu.getSubTitle())
                .brandId(spu.getBrandId())
                .categoryId1(spu.getCategoryId1())
                .categoryId2(spu.getCategoryId2())
                .categoryId3(spu.getCategoryId3())
                .valid(true)
                .saleable(true)
                .createTime(date)
                .lastUpdateTime(date)
                .build();
        mSpuMapper.insertSelective(spuEntity);

        // 添加详情
        SpuDetailEntity spuDetailEntity = spu.getSpuDetail();
        spuDetailEntity.setSpuId(spuEntity.getId());
        mSpuDetailMapper.insertSelective(spuDetailEntity);

        // 添加sku, stock
        spu.getSku().forEach(sku -> {
            // sku
            sku.setSpuId(spuEntity.getId());
            sku.setCreateTime(date);
            sku.setLastUpdateTime(date);
            mSkuMapper.insertSelective(sku);

            // 存储
            mStockMapper.insertSelective(
                    StockEntity.builder()
                            .skuId(sku.getSpuId())
                            .stock(sku.getStock())
                            .build()
            );
        });
    }

    // 修改商品
    @Transactional
    public void updateGoods(SpuBo spu) {
        // 删除老版本，再添加数据

    }

    public SpuDetailEntity querySpuDetailBySpuId(Long spuId) {
        return null;
    }

    public List<SkuEntity> querySkuListBySpuId(Long spuId) {
        return null;
    }


}
