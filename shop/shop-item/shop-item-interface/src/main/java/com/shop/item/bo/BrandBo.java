package com.shop.item.bo;

import com.shop.item.entities.BrandEntity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BrandBo extends BrandEntity {

    private Long categoryId;

}
