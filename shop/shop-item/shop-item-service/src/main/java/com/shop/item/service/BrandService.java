package com.shop.item.service;

import com.shop.common.pojo.PageResponseEntity;
import com.shop.item.ResponseEntity;
import com.shop.item.mapper.BrandMapper;
import com.shop.item.pojo.Brand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BrandService {

    @Resource
    private BrandMapper brandMapper;

    public PageResponseEntity<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {



        return null;
    }
}
