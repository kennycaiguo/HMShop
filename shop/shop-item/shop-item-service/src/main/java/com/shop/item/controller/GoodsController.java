package com.shop.item.controller;

import com.shop.common.pojo.PageResponseEntity;
import com.shop.common.pojo.ResponseEntity;
import com.shop.item.bo.SpuBo;
import com.shop.item.entities.SkuEntity;
import com.shop.item.entities.SpuDetailEntity;
import com.shop.item.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService mGoodsService;

    // 查询spu
    @GetMapping("/spu/page")
    public ResponseEntity<PageResponseEntity<SpuBo>> querySpuByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows) {

        PageResponseEntity<SpuBo> pageResponseEntity = mGoodsService.querySpuByPage(key, saleable, page, rows);
        return pageResponseEntity == null
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(pageResponseEntity);
    }


    // 查询spu detail
    @GetMapping("/spu/detail/{spuId}")
    public ResponseEntity<SpuDetailEntity> querySpuDetailBySpuId(@PathVariable("spuId") Long spuId) {
        SpuDetailEntity spuDetail = mGoodsService.querySpuDetailBySpuId(spuId);
        return spuDetail == null
                ? ResponseEntity.status(ResponseEntity.Status.NOT_FOUND)
                : ResponseEntity.ok(spuDetail);
    }


    // 根据spu id 查询sku
    @GetMapping("/sku/list/{spuId}")
    public ResponseEntity<List<SkuEntity>> querySkuListBySpuId(@PathVariable("spuId") Long spuId) {
        return ResponseEntity.ok(mGoodsService.querySkuListBySpuId(spuId));
    }


    // 添加商品
    @PostMapping("/add")
    public ResponseEntity<Void> addGoods(@RequestBody SpuBo spu) {
        mGoodsService.addGoods(spu);
        return ResponseEntity.ok(null);
    }


    // 更新商品
    @PutMapping("/update")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spu) {
        mGoodsService.updateGoods(spu);
        return ResponseEntity.ok(null);
    }

}
