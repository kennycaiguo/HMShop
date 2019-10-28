package com.shop.item.controller;

import com.shop.item.ResponseEntity;
import com.shop.item.pojo.Category;
import com.shop.item.service.CategoryService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/list/{pid}")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@PathVariable(name = "pid") Long pid) {
        if (pid < 0) {
            return ResponseEntity.status(ResponseEntity.Status.BAD_REQUEST);
        }

        List<Category> categories = categoryService.queryCategoriesByPid(pid);
        return CollectionUtils.isEmpty(categories)
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(categories);
    }
}
