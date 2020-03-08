package com.shop.item.controller;

import com.shop.common.pojo.ResponseEntity;
import com.shop.item.entities.SpecGroupEntity;
import com.shop.item.entities.SpecParamEntity;
import com.shop.item.service.SpecificationService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/spec")
public class SpecificationController {

    @Resource
    private SpecificationService mSpecificationService;

    // 添加规格参数组
    @PostMapping("/groups/add")
    public ResponseEntity<Void> addSpecGroup(@RequestBody SpecGroupEntity specGroup) {
        int id = mSpecificationService.addSpecGroup(specGroup);
        return id != -1
                ? ResponseEntity.ok(null)
                : ResponseEntity.status(ResponseEntity.Status.BAD_REQUEST);
    }

    // 根据分类id查询规格参数组
    @GetMapping("groups/{category_id}")
    public ResponseEntity<List<SpecGroupEntity>> queryGroupsByCategoryId(@PathVariable("category_id") Long id) {
        List<SpecGroupEntity> specGroupEntities = this.mSpecificationService.queryGroupsByCategoryId(id);

        return CollectionUtils.isEmpty(specGroupEntities)
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(specGroupEntities);
    }

    // 查询所有规格参数组
    @GetMapping("/groups")
    public ResponseEntity<List<SpecGroupEntity>> queryGroups() {
        List<SpecGroupEntity> specGroupEntities = this.mSpecificationService.queryGroups();
        return CollectionUtils.isEmpty(specGroupEntities)
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(specGroupEntities);
    }

    // 添加规格参数
    @PostMapping("/params/add")
    public ResponseEntity<Void> addParams(@RequestBody SpecParamEntity specParam) {
        mSpecificationService.addParams(specParam);
        return ResponseEntity.ok(null);
    }

    // 修改规格参数
    @PutMapping("/params/update")
    public ResponseEntity<Void> updateParams(@RequestBody SpecParamEntity specParam) {
        return mSpecificationService.updateParams(specParam) != -1
                ? ResponseEntity.ok(null)
                : ResponseEntity.status(ResponseEntity.Status.BAD_REQUEST);
    }

    // 查询规格参数
    @GetMapping("/params")
    public ResponseEntity<List<SpecParamEntity>> queryParams(
            @RequestParam(value = "groupId", required = false) Long groupId,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "generic", required = false) Boolean generic,
            @RequestParam(value = "searching", required = false) Boolean searching
    ) {

        List<SpecParamEntity> specParamEntities = mSpecificationService.queryParams(groupId, categoryId, generic, searching);
        return CollectionUtils.isEmpty(specParamEntities)
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(specParamEntities);
    }

}
