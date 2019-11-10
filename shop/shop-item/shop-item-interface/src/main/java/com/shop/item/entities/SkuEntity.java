package com.shop.item.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@ToString
@Table(name = "HM_SKU")
public class SkuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // sup id
    private Long supId;

    // 标题
    private String title;

    // 图片
    private String images;

    // 价格，单位为分
    private Long price;

    // 特有规格属性在SPU属性模板中的对应下标组合
    private String indexes;

    // SPU特有规格键值对
    private String ownSpec;

    // 是否有效
    private Boolean enable;

    // 创建时间
    private Long createTime;

    // 最后修改时间
    private Long lastUpdateTime;

}
