<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <!-- <h2>
      Ecosystem
      <input type="text" size="8" v-model="nextItemText">
      <button v-on:click.stop="post">{{target}}</button>
    </h2>
    
    <ul>
      <li v-for="item in items" v-bind:key="item.id">
        <a href="#">{{item.name}}</a>
      </li>
    </ul>-->
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      target: "add",
      nextItemText: "",
      nextItemId: 4,
      items: [
        {
          name: "vue-router",
          id: 1
        },
        {
          name: "vue-loader",
          id: 2
        }
      ]
    };
  },
  methods: {
    post: function(event) {
      this.items.push({
        name: this.nextItemText,
        id: this.nextItemId++
      });

      this.nextItemText = "";
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
