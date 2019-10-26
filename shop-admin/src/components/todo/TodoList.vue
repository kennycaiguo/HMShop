<template>
  <div>
    <h1>{{title}}</h1>
    <todo-add />
    <ul>
      <todo-item v-for="item in items" v-bind:key="item.id" v-bind:content="item.content" />
    </ul>
  </div>
</template>

<script>
import TodoAdd from "./TodoAdd";
import TodoItem from "./TodoItem";

export default {
  name: "TodoList",
  components: {
    TodoAdd,
    TodoItem
  },
  data() {
    return {
      title: "Todo list",
      items: [
        {
          content: "Android",
          id: 1
        }
      ]
    };
  },
  methods: {}
};
</script>