<template>
  <div class=".container">
    <!-- 添加，修改 对话框 -->
    <el-dialog title="添加品牌" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="品牌名称" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="品牌首字母" :label-width="formLabelWidth">
          <el-input v-model="form.letter" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 搜索 -->
    <el-input v-model="searchContent" placeholder="输入关键字搜索..." type="search">
      <template slot="prepend">
        <i class="el-icon-search"></i>
      </template>
    </el-input>

    <!-- 表格 -->
    <el-table
      :data="tableData"
      style="width: 100%;"
      :default-sort="{prop: 'date', order: 'descending'}"
    >
      <el-table-column prop="id" label="ID" sortable width="180"></el-table-column>
      <el-table-column prop="name" label="品牌名称" sortable width="180"></el-table-column>
      <el-table-column prop="image" label="品牌标志">
        <template slot-scope="scope">
          <el-image :src="scope.row.image" :fit="contain"></el-image>
        </template>
      </el-table-column>
      <el-table-column prop="letter" label="首字母" sortable width="180"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleEditClick(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="handleClick(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
      background
      layout="prev, pager, next"
      :page-count="pageCount"
      @current-change="handleCurrentChange"
    ></el-pagination>
  </div>
</template>
<script>
export default {
  name: "Brand",

  data() {
    return {
      searchContent: "",
      pageCount: 0,
      dialogFormVisible: false,
      formLabelWidth: "120px",
      tableData: [],
      form: {
        id:'',
        name: "",
        letter: ""
      }
    };
  },

  created() {
    this.getData({ page: 1 });
  },

  watch: {
    searchContent(value) {
      this.getData({ key: value });
    }
  },

  methods: {
    handleCurrentChange(page) {
      this.getData({ page });
    },

    getData(params) {
      this.axios.get("item/brand/page", { params }).then(response => {
        const { total, items } = response.data;
        this.pageCount = total;
        this.tableData = items;
      });
    },

    handleEditClick(row) {
      this.dialogFormVisible = true;
      this.form = row
    }
  }
};
</script>

<style scoped>
.container {
  height: 100%;
}
.el-image {
  width: 100px;
  height: 50px;
}
</style>