package com.shop.item.bo;

import com.shop.item.entities.SkuEntity;
import com.shop.item.entities.SpuDetailEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class SpuBo {

    // spu id
    private Long spuId;

    // 品牌Id
    private Long brandId;

    // 一级分类Id
    private Long categoryId1;

    // 二级分类Id
    private Long categoryId2;

    // 三级分类Id
    private Long categoryId3;

    // 分类名称
    private String categoryName;

    // 名牌名称
    private String brandName;

    // 标题
    private String title;

    // 副标题
    private String subTitle;

    // 是否上架
    private Boolean saleable;

    // 是否有效
    private Boolean valid;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date lastUpdateTime;

    // 详情
    private SpuDetailEntity spuDetail;

    // sku
    private List<SkuEntity> sku;
}
