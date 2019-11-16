package com.shop.item.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@ToString
@Table(name = "HM_SPU")
public class SpuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 品牌Id
    private Long brandId;

    // 一级分类Id
    private Long categoryId1;

    // 二级分类Id
    private Long categoryId2;

    // 三级分类Id
    private Long categoryId3;

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
}
