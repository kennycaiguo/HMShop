<template>
  <el-container>
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['2']">
        <router-link to="/">
          <el-menu-item index="1">主页</el-menu-item>
        </router-link>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-s-goods"></i>商品管理
          </template>
          <el-menu-item-group>
            <router-link to="/goods/category">
              <el-menu-item index="2-1">分类管理</el-menu-item>
            </router-link>
            <router-link to="/goods/brand">
              <el-menu-item index="2-2">品牌管理</el-menu-item>
            </router-link>
            <el-menu-item index="2-3">商品列表</el-menu-item>
            <router-link to="/goods/specification">
              <el-menu-item index="2-4">规格参数</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>

      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}

.el-menu {
  min-height: 100%;
}
</style>

<script>
export default {
  name: "Layout",
  data() {
    const item = {
      date: "2016-05-02",
      name: "王小虎",
      address: "上海市普陀区金沙江路 1518 弄"
    };
    return {
      tableData: Array(20).fill(item)
    };
  }
};
</script>