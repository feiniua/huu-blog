<template>
  <div id="singleTag">
    <div class="wrapper">
      <Nav></Nav>
      <div class="content">
        <div class="back"><router-link to="/tag"><el-tag class="eltag" type="infonpm run dev">返回</el-tag></router-link></div>
        <span class="title"><i class="el-icon-price-tag"></i> {{tagName}}</span>
        <br/>
        <span class="total">total: {{total}}</span>
        <div class="body" v-for="item in message">
          <div class="article">
            <li>
              <router-link :to="{name: 'v-article', params: {id: item.id}}">
                <span class="time">{{formatDate(item.createAt)}}</span>
                <span class="article">{{item.title}}</span>
              </router-link>
            </li>
          </div>
        </div>
      </div>
      <Footing class="footing"></Footing>
      <img class="background" src="../../static/img/tag.png"/>
    </div>
  </div>
</template>

<script>
  import UrlInfo from "../config/UrlInfo";
  import Nav from "../components/Nav";
  import Footing from "../components/Footing";

  export default {
    components: {Footing, Nav},
    props: ['tagName'],
    name: "SingleTag",
    methods: {
      formatDate: function (date) {
        let year = date.substring(0,4);
        let month = date.substring(5,7);
        let day = date.substring(8,10);
        let time = date.substring(11,19);
        return year + '-' + month + '-' + day + " " + time;
      }
    },
    created() {
      let that = this;
      let url = UrlInfo.url;
      this.axios({
        method: 'get',
        url: url + '/api/article/byTagName',
        params: {
          tagName: that.tagName
        }
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
  * {
    padding: 0;
    margin: 0;
  }
  .wrapper {
    position: relative;
  }
  .content {
    position: relative;
    padding-bottom: 120px;
    margin: 0 auto;
    min-height: 440px;
    width: 70%;
    background-color: #DCDFE5;
    top: 80px;
    border-radius: 20px;
  }
  .content .back {
    position: absolute;
    top: 25px;
    left: 50px;
  }
  .content .back .eltag {
    width: 50px;
  }
  .content .title {
    margin: 0 auto;
    font-size: 25px;
    position: relative;
    top: 35px;
  }
  .content .total {
    margin: 0 auto;
    font-size: 15px;
    position: relative;
    top: 45px;
  }
  .content .body {
    position: relative;
    top: 80px;
    display: flex;
    width: 50%;
    margin: 0 auto;
    border-left: #2aa4aa dotted 1px;
    border-bottom: #5579aa dotted 1px;
    border-bottom-left-radius: 20px;
  }
  .content .body:hover {
    border-left: #aa352f dotted 1px;
    border-bottom: #aa7171 dotted 1px;
  }
  .content .body .article {
    height: 30px;
    line-height: 30px;
    padding: 10px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .content .body .article .time {
    font-size: 12px;
    color: #222a4a;
    padding-right: 20px;
    padding-left: 10px;
    padding-bottom: 5px;
  }
  li {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .background {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 120%;
    z-index: -2;
  }
  .footing {
    position: relative;
    top: 90px;
  }
  a {
    color: #2c7181;
  }
  a:hover {
    color: #000;
  }
  a:active {
    color: #acffde;
  }
</style>
