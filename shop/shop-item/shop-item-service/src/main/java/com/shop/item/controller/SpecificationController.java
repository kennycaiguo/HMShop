package com.shop.item.controller;

import com.shop.common.pojo.ResponseEntity;
import com.shop.item.entities.SpecGroupEntity;
import com.shop.item.service.SpecificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/spec")
public class SpecificationController {

    @Resource
    private SpecificationService mSpecificationService;

    @GetMapping("groups/{category_id}")
    public ResponseEntity<List<SpecGroupEntity>> queryGroupsByCategoryId(@PathVariable("category_id") Long id) {
        List<SpecGroupEntity> specGroupEntities = this.mSpecificationService.queryGroupsByCategoryId(id);
        if (specGroupEntities.isEmpty()) {
            return ResponseEntity.status(ResponseEntity.Status.NOT_FOUND);
        }

        return ResponseEntity.ok(specGroupEntities);
    }
}
