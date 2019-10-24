package com.shop.item.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Category {

    private Long id;
    private String name;
    private Integer sort;
    private Long parentId;
    private Boolean isParent;

}
