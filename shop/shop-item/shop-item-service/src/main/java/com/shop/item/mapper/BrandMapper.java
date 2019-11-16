package com.shop.item.mapper;

import com.shop.item.entities.BrandEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<BrandEntity> {

    @Insert("INSERT INTO HM_CATEGORY_BRAND (CATEGORY_ID, BRAND_ID) VALUES (#{categoryId}, #{brandId})")
    void insertCategoryAndBrand(@Param("categoryId") Long categoryId, @Param("brandId") Long brandId);

    @Select("SELECT * FROM HM_BRAND a INNER JOIN HM_CATEGORY_BRAND b ON a.id = b.brand_id WHERE b.category_id = #{categoryId}")
    List<BrandEntity> selectBrandByCategoryId(Long categoryId);
}
