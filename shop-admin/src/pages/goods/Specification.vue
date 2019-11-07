<template>
  <el-container>
    <el-aside width="200px" class=".el-aside">
      <el-tree :props="props" :load="loadNode" lazy></el-tree>
    </el-aside>
    <el-main>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="ID" width="180"></el-table-column>
        <el-table-column prop="groupName" label="组名" width="180"></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button type="text" size="small">编辑</el-button>
            <el-button @click="handleClick(scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>
<script>
export default {
  data() {
    return {
      props: {
        label: "name",
        children: "zones",
        isLeaf: "leaf"
      },

      data: [
        {
          label: "一级 1",
          children: [
            {
              label: "二级 1-1",
              children: [
                {
                  label: "三级 1-1-1"
                }
              ]
            }
          ]
        },
        {
          label: "一级 2",
          children: [
            {
              label: "二级 2-1",
              children: [
                {
                  label: "三级 2-1-1"
                }
              ]
            },
            {
              label: "二级 2-2",
              children: [
                {
                  label: "三级 2-2-1"
                }
              ]
            }
          ]
        },
        {
          label: "一级 3",
          children: [
            {
              label: "二级 3-1",
              children: [
                {
                  label: "三级 3-1-1"
                }
              ]
            },
            {
              label: "二级 3-2",
              children: [
                {
                  label: "三级 3-2-1"
                }
              ]
            }
          ]
        }
      ],

      tableData: [
        {
          id: "2016-05-02",
          groupName: "王小虎"
        },
        {
          id: "2016-05-04",
          groupName: "王小虎"
        }
      ]
    };
  },

  methods: {
    loadNode(node, resolve) {
      this.getData(resolve, node.level);
    },

    getData(resolve, id) {
      this.axios.get(`item/category/list/${id}`).then(response => {
        resolve(
          response.data.map(item => {
            return {
              vlaue: item.parentId,
              name: item.name,
              leaf: !item.isParent
            };
          })
        );
      });
    }
  }
};
</script>
<style scoped>
.el-aside {
  border-right: 1px solid #ccc;
}
</style>