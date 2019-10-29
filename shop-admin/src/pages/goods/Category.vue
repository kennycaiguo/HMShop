<template>
  <div>
    <el-cascader-panel :props="props"></el-cascader-panel>
  </div>
</template>

<script>
let id = 0;

export default {
  name: "Category",
  data() {
    let vm = this;

    return {
      props: {
        lazy: true,
        lazyLoad(node, resolve) {
          vm.axios.get(`/category/list/${id}`).then(response => {
            resolve(
              response.data.map(item => {
                return {
                  vlaue: id++,
                  label: item.name,
                  leaf: !item.isParent
                };
              })
            );
          });
        }
      }
    };
  },
  created() {
    this.getAnswer();
  },
  methods: {
    getAnswer() {
      // this.axios.get("/category/list/0").then(response => {
      //   this.$message(JSON.stringify(response));
      // });
    }
  }
};
</script>