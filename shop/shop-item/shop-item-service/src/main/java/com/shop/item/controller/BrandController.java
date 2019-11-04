package com.shop.item.controller;

import com.shop.common.pojo.PageResponseEntity;
import com.shop.item.ResponseEntity;
import com.shop.item.bo.BrandBo;
import com.shop.item.entities.BrandEntity;
import com.shop.item.service.BrandService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * 根据查询条件分页并排序查询品牌信息
     */
    @GetMapping("/page")
    public ResponseEntity<PageResponseEntity<BrandEntity>> queryBrandsByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc) {

        PageResponseEntity<BrandEntity> entity = brandService.queryBrandsByPage(key, page, rows, sortBy, desc);
        return CollectionUtils.isEmpty(entity.getItems())
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(entity);
    }

    /**
     * 添加品牌
     */
    @PostMapping("/add")
    public ResponseEntity add(BrandEntity brand, List<Long> categoryIds) {
        brandService.add(brand, categoryIds);
        return ResponseEntity.ok(null);
    }

}
