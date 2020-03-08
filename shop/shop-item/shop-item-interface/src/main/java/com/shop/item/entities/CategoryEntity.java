package com.shop.item.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "HM_CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 分类名称
    private String name;

    // 父节点Id
    private Long parentId;

    // 是否为父节点
    private Boolean isParent;

    public CategoryEntity() {

    }

    public CategoryEntity(Long parentId) {
        this.parentId = parentId;
    }
}
