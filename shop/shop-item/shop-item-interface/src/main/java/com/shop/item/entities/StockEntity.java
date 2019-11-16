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
@Table(name = "HM_STOCK")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // SKU id
    private Long skuId;

    // 库存数量
    private Integer stock;

    // 秒杀库存数量
    private Integer secKillStock;

    // 秒杀数量
    private Integer secKillTotal;
}
