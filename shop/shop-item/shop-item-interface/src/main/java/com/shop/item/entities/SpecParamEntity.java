package com.shop.item.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "HM_SPEC_PARAM")
public class SpecParamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String unit;

    private Long groupId;

    private Long categoryId;

    private String segments;

    private Boolean numeric;

    private Boolean generic;

    private Boolean searching;
}
