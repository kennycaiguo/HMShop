package com.shop.common.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 分页响应
 */
@Data
@ToString
public class PageResponseEntity<T> {

    public static <T> PageResponseEntity<T> create(Integer total, Integer current, List<T> items) {
        PageResponseEntity<T> pageResponseEntity = new PageResponseEntity<>();
        pageResponseEntity.setTotal(total);
        pageResponseEntity.setCurrent(current);
        pageResponseEntity.setItems(items);
        return pageResponseEntity;
    }

    // 总页数
    private Integer total;

    // 当前页数
    private Integer current;

    // 数据
    private List<T> items;
}
