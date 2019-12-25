package com.shop.item.controller;

import com.shop.common.pojo.ResponseEntity;
import com.shop.item.entities.CategoryEntity;
import com.shop.item.service.CategoryService;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService mCategoryService;

    /**
     * 查询分类
     */
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

    /**
     * 添加分类
     */
    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody CategoryEntity category) {
        mCategoryService.addCategory(category);
        return ResponseEntity.ok(null);
    }

    /**
     * 修改分类
     */
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody CategoryEntity category) {
        if (ObjectUtils.isEmpty(category)) {
            return ResponseEntity.status(405, "参数错误");
        }

        return mCategoryService.update(category)== 0
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(null);
    }

    /**
     * 删除分类
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        return mCategoryService.delete(id) == 0
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(null);
    }
}
