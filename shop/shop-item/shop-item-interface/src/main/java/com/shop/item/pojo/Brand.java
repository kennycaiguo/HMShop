package com.shop.item.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "HM_BRAND")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    // 名称
    private String name;

    // Logo
    private String image;

    // 首字母
    private Character letter;

}
