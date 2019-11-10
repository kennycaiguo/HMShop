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
@Table(name = "HM_SPU_DETAIL")
public class SpuDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // sup id
    private Long supId;

    // 商品描述
    private String description;

    // 通用规格参数数据
    private String genericSpec;

    // 特有规格参数及可选信息
    private String specialSpec;

    // 包装清单
    private String packingList;

    // 售后服务
    private String afterService;

}
