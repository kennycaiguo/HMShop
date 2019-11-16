package com.shop.item.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@ToString
@Table(name = "HM_SKU")
public class SkuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // sup id
    private Long spuId;

    // 标题
    private String title;

    // 图片
    private String images;

    // 价格，单位为分
    private Long price;

    // 特有规格属性在SPU属性模板中的对应下标组合
    private String indexes;

    // spu 特有规格键值对
    private String ownSpec;

    // 是否有效
    private Boolean enable;

    // 库存
    @Transient
    private Integer stock;

    // 创建时间
    private Date createTime;

    // 最后修改时间
    private Date lastUpdateTime;

}
