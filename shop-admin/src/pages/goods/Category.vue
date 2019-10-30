<template>
  <div>
    <el-cascader-panel :props="props" @expand-change="handleChange"></el-cascader-panel>
  </div>
</template>

<script>
export default {
  name: "Category",

  data() {
    let vm = this;
    return {
      props: {
        lazy: true,
        lazyLoad(node, resolve) {
          vm.getData(resolve, node.level);
        }
      }
    };
  },

  methods: {
    handleChange() {
      //alert(JSON.stringify(v))
    },

    getData(resolve, id) {
      this.axios.get(`/category/list/${id}`).then(response => {
        resolve(
          response.data.map(item => {
            return {
              vlaue: item.parentId,
              label: item.name,
              leaf: !item.isParent
            };
          })
        );
      });
    }
  }
};
</script>