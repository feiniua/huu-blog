<template>
  <!--  时间归档页-->
  <div id="time">
    <div class="wrapper">
      <Nav></Nav>
      <div class="content">
        <span class="title"><i class="el-icon-date"></i> 归档</span>
        <br/>
        <span class="total">Total: {{total}}</span>
        <div class="body" v-for="(item, index) in message">
          <li>
            <router-link :to="{name: 'v-article', params: {id: item.id}}">
              <span class="time">{{formatDate(item.createAt)}}</span>
              <span class="article">{{item.title}}</span>
            </router-link>
          </li>
        </div>
      </div>
      <Footing class="footing"></Footing>
      <img src="../../static/img/time.jpg"/>
    </div>
  </div>
</template>

<script>
  import Nav from "../components/Nav";
  import Footing from "../components/Footing";
  import UrlInfo from "../config/UrlInfo";

  export default {
    name: "Time",
    components: {
      Footing,
      Nav
    },
    methods: {
      formatDate: function (date) {
        let year = date.substring(0,4);
        let month = date.substring(5,7);
        let day = date.substring(8,10);
        let time = date.substring(11,19);
        return year + "-" + month + "-" + day + " " + time;
      }
    },
    created() {
      let that = this;
      let url = UrlInfo.url;
      this.axios({
        method: 'get',
        url: url + 'api/article/byTime'
      }).then(function (response) {
        that.message = response.data.data;
        that.total = response.data.data.length;
      })
    },
    data() {
      return {
        message: {},
        total: ""
      }
    }
  }
</script>

<style scoped>
  .wrapper {
    width: 100%;
    position: relative;
  }

  .wrapper .content {
    position: relative;
    top: 80px;
    background-color: #DCDFE6;
    opacity: 0.9;
    min-height: 750px;
    width: 70%;
    margin: 0 auto;
    padding-bottom: 80px;
  }

  .wrapper .content .title {
    position: relative;
    top: 30px;
    font-size: 19px;
  }
  .wrapper .content .total {
    position: relative;
    top: 40px;
    font-size: 15px;
  }
  .wrapper .content .body {
    position: relative;
    top: 50px;
    left: 78px;
    width: 50%;
    margin: 0 auto;
    display: flex;
    padding-top: 5px;
    padding-left: 100px;
    height: 50px;
    border-left: #63656a solid 5px;
  }
  .wrapper .content .body:hover {
    border-left: #416b52 solid 5px;
  }
  .body li {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;

  }
  .time {
    margin-right: 20px;
    color: #515d60;
    font-size: 11px;
    line-height: 40px;
  }
  a {
    color: #46626b;
  }
  a:hover {
    color: #4faa86;
  }

  .footing {
    position: relative;
    top: 85px;
    padding: 5px;
    text-shadow: #276450 1px 0;
  }

  img {
    position: fixed;
    top: 0;
    left: 0;
    z-index: -2;
    width: 100%;
    height: 120%;
  }
</style>
