package com.shop.item.controller;

import com.shop.common.pojo.PageResponseEntity;
import com.shop.item.ResponseEntity;
import com.shop.item.pojo.Brand;
import com.shop.item.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * 根据查询条件分页并排序查询品牌信息
     */
    @GetMapping("/page")
    public ResponseEntity<PageResponseEntity<Brand>> queryBrandsByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "desc", required = false) Boolean desc) {

        PageResponseEntity<Brand> brandPageResponseEntity = brandService.queryBrandsByPage(key, page, rows, sortBy, desc);

        return null;
    }
}
