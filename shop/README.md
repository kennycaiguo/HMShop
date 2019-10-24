# HMShop
> 黑马商城 (Spring-Cloud)
>
功能：下单、生成订单、支付

## 模块说明
- HMShop： 父工程，管理版本
    - shop-register：eureka 注册中心
    - shop-gateway： 网关工程，拦截并分发请求
    - shop-item
        - shop-item-interface：pojo 对象
        - shop-item-service：  对外提供rest接口的具体实现
