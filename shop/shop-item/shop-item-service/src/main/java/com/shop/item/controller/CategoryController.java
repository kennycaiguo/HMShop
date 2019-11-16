package com.shop.item.controller;

import com.shop.common.pojo.ResponseEntity;
import com.shop.item.entities.CategoryEntity;
import com.shop.item.service.CategoryService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService mCategoryService;

    @GetMapping("/list/{pid}")
    public ResponseEntity<List<CategoryEntity>> queryCategoriesByPid(@PathVariable(name = "pid") Long pid) {
        if (pid < 0) {
            return ResponseEntity.status(ResponseEntity.Status.BAD_REQUEST);
        }

        List<CategoryEntity> categories = mCategoryService.queryCategoriesByPid(pid);
        return CollectionUtils.isEmpty(categories)
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(categories);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody CategoryEntity category){
        mCategoryService.addCategory(category);
        return ResponseEntity.ok(null);
    }
}
