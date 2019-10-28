<template>
  <div>
    <input type="text" placeholder="please submit ..." v-model="msg"/>
    <button v-on:click="$emit('submitt', msg)">submit</button>
  </div>
</template>
    
<script>
export default {
  name: "TodoAdd",
  data() {
    return {
      msg: ''
    };
  },
  methods: {}
};
</script>