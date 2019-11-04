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
    private String  name;
//    private Integer sort;
    private Long    parentId;
    private Boolean isParent;

    public CategoryEntity(){

    }

    public CategoryEntity(Long parentId){
        this.parentId = parentId;
    }

}
