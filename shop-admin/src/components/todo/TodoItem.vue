<template>
  <li class="item">
    <span>{{content}}</span>
    <button>删除</button>
  </li>
</template>

<script>
export default {
  name: "TodoItem",
  props: {
      content: String
  }
};
</script>

<style scoped>
li {
  list-style: none;
  padding: 0;
  margin: 0;
  border-bottom: 1px solid #efefef;
}
.item {
  padding: 4px 0;
}
</style>