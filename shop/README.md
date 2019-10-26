# HMShop
> 黑马商城 (Spring-Cloud)

功能：
- 购买商品、加入购物车、下单、用户、搜索
- 管理员对商品上下架 
- 千万用户使用

## 模块说明
- HMShop： 父工程，管理版本
    - shop-register：eureka 注册中心
    - shop-gateway： 网关工程，拦截并分发请求
    - shop-item
        - shop-item-interface：pojo 对象
        - shop-item-service：  对外提供rest接口的具体实现
