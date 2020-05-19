<template>
  <div class="notFound">
    <div class="wrapper">
      <div class="content">
        <div class="heading">
          <div class="title"><i class="el-icon-loading"></i> {{this.$route.path}}</div>
          <div class="nav">
            <button class="button1" @click="back">-</button>
            <button class="button2" @click="back">□</button>
            <button class="button3" @click="back">x</button>
          </div>
        </div>
        <div class="body">
          <span class="span1">404</span><br/>
          <span class="span2">You are lost.</span>
          <span class="span3">timestamp:{{date}}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "404",
    mounted() {
      this.clear=setInterval(() => {
        this.initDate();
      }, 1000)
    },
    // 页面关闭时清除计时器
    beforeDestroy() {
      clearInterval(this.clear);
    },
    methods: {
      initDate: function () {
        this.date = new Date().getTime()
      },
      back: function () {
        this.$router.push({path: "/"});
      }
    },
    data: function() {
      return {
        date: new Date().getTime()
      }
    }
  }
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }

  .wrapper {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    overflow-y: auto;
    background-color: #a0c1c1;
  }

  .content {
    position: relative;
    top: 40%;
    left: 50%;
    margin-top: -90px;
    margin-left: -180px;
    width: 360px;
    height: 180px;
    border: 0.1px solid #7d7979;
    background-color: #DCDFE6;
    box-shadow: 2px 2px #35655b;
  }

  .content .title {
    margin-top: 5px;
    margin-left: 5px;
    position: absolute;
    color: #265a32;
    font-size: 19px;
    text-shadow: 1px 1px 0px #6bab7a;
  }

  .content .heading {
    width: 100%;
    height: 20%;
    border-bottom-color: #35655b;
    border-bottom-style: double;
  }

  .nav {
    margin-top: 4px;
    float: right;
    height: 100%;
  }

  .nav:after {
    content: "";
    display: inline-block;
    clear: both;
  }

  .nav button {
    height: 25px;
    width: 25px;
    line-height: 100%;
  }
  .nav button:hover {
    color: cornflowerblue;
  }

  .button1 {
    outline: none;
  }

  .button2 {

  }

  .button3 {
    margin-right: 3px;
  }

  .body {

  }

  .content span {
    color: #265a32;
    font-size: 19px;
    text-shadow: 1px 1px 0px #6bab7a;
    -webkit-user-select:none;
    -moz-user-select:none;
    -ms-user-select:none;
  }

  .content .span1 {
    position: absolute;
    top: 45px;
    left: 10px;
  }

  .content .span2 {
    position: absolute;
    top: 65px;
    left: 10px;
  }
  .content .span3 {
    position: absolute;
    top: 85px;
    left: 10px;
  }
</style>
