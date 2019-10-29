CREATE TABLE HM_CATEGORY
(
    ID        bigint(20)  not null auto_increment comment '类目id',
    NAME      varchar(20) not null comment '名称',
    PARENT_ID bigint(20)  not null comment '父类目id, 顶级类目为0',
    IS_PARENT tinyint(1)  not null comment '是否为父节点，0为否，1为是',
    primary key (ID)
);

CREATE TABLE HM_BRAND
(
    ID     bigint(20)   not null auto_increment,
    NAME   varchar(50)  not null,
    IMAGE  varchar(200) not null comment 'logo',
    LETTER char(1) default '' comment '首字母',
    primary key (id)
);