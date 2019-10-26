<template>
  <div>
    <input type="text" v-model="content" />
    <button v-on="add">Add</button>
  </div>
</template>

<script>
export default {
  name: "TodoAdd",
  props: {
    add: function() {}
  },
  data() {
    return {
      content: ""
    };
  },
  methods: {
    add: function(event) {
      alert("add");
    }
  }
};
</script>