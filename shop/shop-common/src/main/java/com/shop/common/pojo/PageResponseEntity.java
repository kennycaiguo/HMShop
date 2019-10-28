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

    // 总页数
    private Integer total;

    // 当前页数
    private Long    current;

    // 数据
    private List<T> items;
}
