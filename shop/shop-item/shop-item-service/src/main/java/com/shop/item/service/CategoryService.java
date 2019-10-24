package com.shop.item.service;
import com.shop.item.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {

    public List<Category> queryCategoriesByPid(Long pid) {
        return Collections.singletonList(new Category());
    }

}
