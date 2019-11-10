package com.shop.item.controller;

import com.shop.common.pojo.PageResponseEntity;
import com.shop.common.pojo.ResponseEntity;
import com.shop.item.bo.SpuBo;
import com.shop.item.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService mGoodsService;

    @GetMapping("/spu/page")
    public ResponseEntity<PageResponseEntity<SpuBo>> querySpuByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", required = false) String saleable,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows
    ) {

        PageResponseEntity<SpuBo> pageResponseEntity = mGoodsService.querySpuByPage(key, saleable, page, rows);

        return pageResponseEntity == null
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(pageResponseEntity);
    }

}
