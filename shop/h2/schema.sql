CREATE TABLE HM_CATEGORY
(
    ID        BIGINT(20)  not null auto_increment comment '类目id',
    NAME      varchar(20) not null comment '名称',
    PARENT_ID BIGINT(20)  not null comment '父类目id, 顶级类目为0',
    IS_PARENT tinyint(1)  not null comment '是否为父节点，0为否，1为是',
    primary key (ID)
);

CREATE TABLE HM_BRAND
(
    ID     BIGINT(20)   not null auto_increment,
    NAME   varchar(50)  not null,
    IMAGE  varchar(200) not null comment 'logo',
    LETTER char(1) default '' comment '首字母',
    primary key (id)
);

CREATE TABLE HM_CATEGORY_BRAND(
    ID BIGINT(20) NOT NULL AUTO_INCREMENT,
    CATEGORY_ID BIGINT(20) not null,
    GROUP_ID BIGINT(20) not null,
    PRIMARY KEY (ID)
);

CREATE TABLE HM_SPEC_GROUP(
    ID BIGINT(20) not null auto_increment,
    CATEGORY_ID bigint(20) not null,
    NAME VARCHAR(30) NOT NULL,
    primary key (ID)
);

CREATE TABLE HM_SPEC_PARAM(
    ID BIGINT(20) NOT NULL AUTO_INCREMENT,
    CATEGORY_ID BIGINT(20) not null,
    GROUP_ID BIGINT(20) not null,
    NAME VARCHAR(30) NOT NULL,
    UNIT VARCHAR(20) DEFAULT '',
    NUMBERIC TINYINT(1) NOT NULL,
    GENERIC TINYINT(1) NOT NULL COMMENT '是否是sku通用属性',
    SEARCHING TINYINT(1) NOT NULL COMMENT '是否用于搜索过滤',
    SEGMENTS VARCHAR(200) DEFAULT '',
    PRIMARY KEY (ID)
);