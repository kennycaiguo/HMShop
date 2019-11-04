package com.shop.item.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "HM_BRAND")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    // 名称
    private String name;

    // Logo
    private String image;

    // 首字母
    private Character letter;


    public BrandEntity(){
        //
    }

    public BrandEntity(String name, String image, Character letter){
        this.name = name;
        this.image = image;
        this.letter = letter;
    }
}
