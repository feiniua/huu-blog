<template>
  <div class="backend">
    <div class="wrapper">
      <div class="background"></div>
      <div class="heading">
        <router-link to="/backend" class="nav"><i class="el-icon-s-home"></i></router-link>
        <router-link to="/backend/article" class="nav">文章<i class="el-icon-document"></i></router-link>
        <router-link to="/backend/tag" class="nav">标签<i class="el-icon-collection-tag"></i></router-link>
        <router-link to="/backend/user" class="nav">用户<i class="el-icon-user"></i></router-link>
        <router-link to="/" class="home">首页<i class="el-icon-more-outline"></i></router-link>
        <button class="exitbtn" @click="logout()">退出</button>
      </div>
      <div class="body" v-if="this.$route.path === '/backend'">
        <svg viewBox="0 0 1000 300">
          <symbol id="line-text">
            <text text-anchor="middle" x="50%" y="50%" dy=".4em">
              {{username}}
            </text>
          </symbol>

          <use xlink:href="#line-text" class="text"></use>
          <use xlink:href="#line-text" class="text"></use>
          <use xlink:href="#line-text" class="text"></use>
          <use xlink:href="#line-text" class="text"></use>
        </svg>
      </div>
      <el-avatar class="avatar" :size="60"> {{username}}</el-avatar>
      <div class="view">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
  import UrlInfo from "../../config/UrlInfo";

  export default {
    props: ['name'],
    name: "Backend",
    methods: {
      logout: function () {
        this.axios({
          method: "get",
          url: UrlInfo.url + "/api/logout"
        });
        sessionStorage.removeItem('username');
        this.$router.push({name: 'index'});
      }
    },
    data() {
      return {
        username: sessionStorage.getItem("username")
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
    width: 100%;
    position: relative;
  }

  .background {
    background-color: rgba(176, 194, 211, 0.77);
    position: fixed;
    top: 0;
    left: 0;
    z-index: -1;
    width: 100%;
    height: 100%;
  }

  .heading {
    position: absolute;
    top: 50px;
    left: 10px;
    margin: 0 auto;
    min-height: 250px;
    float: left;
    display: flex;
    flex-flow: column;
    background-color: rgba(117, 125, 158, 0.57);
    border-radius: 5px;
    z-index: 2;
  }

  .nav {
    padding: 6px;
    margin-left: 3px;
    margin-right: 3px;
    border-bottom: #8a848c solid 1px;
  }
  .home {
    position: absolute;
    top: -35px;
    left: 12px;
  }
  .exitbtn {
    outline: none;
    position: absolute;
    width: 50px;
    top: 260px;
    left: 6px;
    background-color: #00000020;
    border: 0;
    border-radius: 5px;
  }
  .exitbtn:hover {
    background-color: #DCDFE6;
  }
  .exitbtn:active {
    background-color: #9baaa3;
  }
  a {
    color: #566558;
  }

  a:hover {
    color: #a7c3cf;
  }
  .view {
    position: relative;
    top: 15px;
    padding-left: 120px;
    padding-top: 15px;
  }
  .avatar {
    position: fixed;
    top: 10px;
    right: 30px;
    z-index: 2;
  }

  .body {
    position: absolute;
    left: 30%;
    top: 10%;
    font-size: 150px;
  }
  svg {
    position: absolute;
    width: 500px;
    height: 300px;
  }
  .text {
    fill: none;
    stroke-width: 5;
    stroke-dasharray: 0, 240;
    stroke-dashoffset: 0;
  }
  .text:nth-child(4n + 1) {
    stroke: rgb(39,135,238);
    animation: text1 4s ease-in-out forwards;
  }
  .text:nth-child(4n + 2) {
    stroke: rgb(238, 161, 214);
    animation: text2 4s ease-in-out forwards;
  }
  .text:nth-child(4n + 3) {
    stroke: rgb(174, 238, 159);
    animation: text3 4s ease-in-out forwards;
  }
  .text:nth-child(4n + 4) {
    stroke: rgb(238, 177, 40);
    animation: text4 4s ease-in-out forwards;
  }
  @keyframes text1 {
    100% {
      stroke-dashoffset: 1000;
      stroke-dasharray: 60,180;
    }
  }
  @keyframes text2 {
    100% {
      stroke-dashoffset: 1060;
      stroke-dasharray: 60,180;
    }
  }
  @keyframes text3 {
    100% {
      stroke-dashoffset: 1120;
      stroke-dasharray: 60,180;
    }
  }
  @keyframes text4 {
    100% {
      stroke-dashoffset: 1180;
      stroke-dasharray: 60,180;
    }
  }
</style>
