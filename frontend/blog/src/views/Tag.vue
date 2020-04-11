<template>
<!--  标签页-->
  <div id="tag">
    <div class="wrapper">
      <Nav></Nav>
      <div class="content">
        <div class="title">
          <p class="title-1"><i class="el-icon-collection-tag"></i> 标签</p>
          <br/>
          <p class="total">Total: <router-link to="#">{{tagTotal}}</router-link></p>
        </div>
        <div class="body">
          <span v-for="item in message.data">
            <router-link class="entity" :to="{name : 'v-singleTag', params: {tagName: item.name}}"><el-tag type="sucess">{{item.name}}</el-tag></router-link>
          </span>
        </div>
      </div>
      <Footing class="footing"></Footing>
      <img class="background" src="static/img/tag.png"/>
    </div>
  </div>
</template>

<script>
  import UrlInfo from "../config/UrlInfo";
  import Nav from "../components/Nav";
  import Footing from "../components/Footing";

  export default {
    name: "tag",
    components: {Footing, Nav},
    created() {
      let that = this;
      let url = UrlInfo.url;
      this.axios({
        method: "get",
        url: url + '/api/tag/all'
      }).then(function (response) {
        that.message = response.data;
        that.tagTotal = response.data.data.length;
      })
    },
    data() {
      return {
        message: {},
        tagTotal: ""
      }
    }
  }
</script>

<style scoped>
  * {
    margin: 0;
    padding: 0;
  }
  .wrapper {
    position: relative;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }
  .content {
    position: relative;
    width: 70%;
    min-height: 550px;
    background-color: #DCDFE6;
    top: 80px;
    margin: 0 auto 80px;
    opacity: 0.9;
    border-radius: 5px;
  }
  .title {
    position: relative;
    top: 30px;
  }
  .title .title-1 {
    font-size: 19px;
  }
  .title .total {
    font-size: 15px;
  }
  .wrapper .content .body {
    width: 40%;
    margin: 0 auto;
    position: relative;
    top: 60px;
  }
  .wrapper .content .body:after {
    content: "";
    display: inline-block;
    clear: both;
  }
  .wrapper .content .body .entity {
    padding: 3px 5px;
    float: left;
  }

  .background {
    position: fixed;
    top: 0;
    left: 0;
    z-index: -2;
    width: 100%;
    height: 120%;
  }
  .footing {
    position: relative;
    text-shadow: rgba(191, 175, 193, 0.51) 1px 0;
    padding: 5px;
    top: 35px;
  }
  a {
    color: #2aa4aa;
  }
  a:hover {
    color: #9B8651;
  }
  span:hover {
    background-color: #a9f2fa;
    color: #222a4a;
  }
</style>
