package com.shop.item.bo;

import com.shop.item.entities.BrandEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class BrandBo extends BrandEntity {

    private List<Long> categoryIds;

}
