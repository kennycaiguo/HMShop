package com.shop.item.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "HM_SPEC_GROUP")
public class SpecGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 名称
    private String name;

    // 分类id
    private Long categoryId;

    public SpecGroupEntity() {
        // 预留
    }

    public SpecGroupEntity(Long categoryId) {
        this.categoryId = categoryId;
    }
}
