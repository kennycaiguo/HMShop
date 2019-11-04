package com.shop.item.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "HM_CATEGORY_BRAND")
public class CategoryBrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;

    private Long categoryId;

    public CategoryBrandEntity() {
        // 占位
    }

    public CategoryBrandEntity(Long brandId, Long categoryId) {
        this.brandId = brandId;
        this.categoryId = categoryId;
    }
}
