<template>
  <div class="createArticle">
    <div class="wrapper">
      <div class="heading">
        <span>Title: </span><input class="title" type="text" v-model="title"></input>
      </div>
      <mavon-editor v-model="content"></mavon-editor>
      <div class="footing">
        <button>标签</button>
        <input class="background-img" type="file" name="fileName">
        <button place class="submit">提交</button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "CreateArticle",
    data() {
      return {
        content: "",
        title: ""
      }
    }
  }
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }
  button {
    outline: none;
    border: 0;
    border-radius: 5px;
    color: #DCDFE6;
    background-color: #7d7979;
    margin-right: 3px;
    padding: 2px;
  }
  button:hover {
    background-color: #96aaa7;
  }
  button:active {
    color: #7d7979;
    background-color: #DCDFE6;
  }
  .wrapper {
    min-height: 550px;
  }
  .heading {
    position: relative;
    top: -10px;
    left: -400px;
  }
  .title {
    outline: none;
    border: 0;
    height: 20px;
    margin-right: 20px;
    background-color: #98999e;
    padding: 3px;
  }
  .background-img {
    outline: none;
    border: 0;
  }
  .footing {
    margin-top: 10px;
    position: absolute;
  }
</style>
