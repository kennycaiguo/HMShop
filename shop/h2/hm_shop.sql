CREATE TABLE HM_CATEGORY(
  ID bigint(20) not null auto_increment comment '类目id',
  NAME varchar(20) not null comment '名称',
  PARENT_ID bigint(20) not null comment '父类目id, 顶级类目为0',
  IS_PARENT tinyint(1) not null comment '是否为父节点，0为否，1为是',
  primary key (ID)
);

INSERT INTO PUBLIC.HM_CATEGORY (ID, NAME, PARENT_ID, IS_PARENT) VALUES (1, '图书、影像、电子书刊', 0, 1);
INSERT INTO PUBLIC.HM_CATEGORY (ID, NAME, PARENT_ID, IS_PARENT) VALUES (2, '电子书刊', 1, 1);
INSERT INTO PUBLIC.HM_CATEGORY (ID, NAME, PARENT_ID, IS_PARENT) VALUES (3, '电子书', 2, 0);

CREATE TABLE HM_BRAND(
  id bigint(20) not null auto_increment,
  name varchar(50) not null,
  image varchar(200) not null comment 'logo',
  letter char(1) default '' comment '首字母',
  primary key (id)
);