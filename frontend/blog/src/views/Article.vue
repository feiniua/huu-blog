<template>
  <!--  单篇文章页-->
  <div id="article">
    <div class="wrapper">
      <Nav></Nav>
      <div class="content">
        <div class="article-heading">
          <h1 class="title">
            <router-link to="#">{{message.title}}</router-link>
          </h1>
          <div class="createAt">
            <router-link to="/time">{{getDate(message.createAt)}}</router-link>
          </div>
          <div v-for="tag in message.tags">
            <router-link :to="{name : 'v-singleTag', params: {tagName: tag.name}}">
              <el-tag class="tag" type="success">{{tag.name}}</el-tag>
            </router-link>
          </div>
        </div>
        <div class="body" v-html="priview"></div>
      </div>
      <Footing class="footing"></Footing>
      <img :src="message.imageAddress"/>
    </div>
  </div>
</template>

<script>
  import Nav from "../components/Nav";
  import Marked from 'marked';
  import Footing from "../components/Footing";
  import UrlInfo from "../config/UrlInfo";


  export default {
    components: {Footing, Nav},
    props: ['id'],
    name: "Article",
    // 在页面最开始创建的时候执行
    created() {
      let id = this.$route.params.id;
      let that = this;
      let url = UrlInfo.url;
      this.axios({
        method: 'get',
        url: url + '/api/article/' + id,
      }).then(function (response) {
        that.message = response.data.data;
        that.priview = Marked(response.data.data.content)
      });
    },
    data() {
      return {
        message: {},
        priview: {}
      }
    },
    methods: {
      getDate: function (date) {
        let year = date.substring(0, 4);
        let month = date.substring(5, 7);
        let day = date.substring(8, 10);
        let time = date.substring(11, 19);
        return year + '-' + month + '-' + day + " " + time;
      }
    }
  }
</script>

<style scoped>
  .wrapper {
    width: 100%;
    height: auto;
    position: relative;
  }

  img {
    position: fixed;
    top: 0;
    left: 0;
    z-index: -2;
    width: 100%;
    height: 110%;
  }

  .content {
    text-align: left;
    position: relative;
    width: 80%;
    height: auto;
    min-height: 500px;
    background-color: #EBEEF5;
    top: 80px;
    left: 10%;
    opacity: 0.9;
    padding: 20px;
    border-radius: 50px;
    margin-bottom: 20px;
  }

  .article-heading .title a {
    color: #ff5353;
  }

  .article-heading .title a:hover {
    color: #ff9e9b;
  }

  .article-heading .title a:active {
    color: #EBEEF5;
  }

  .article-heading h1 {
    text-align: center;
  }

  .article-heading .createAt {
    float: left;
  }

  .article-heading .tag {
    float: right;
  }

  .article-heading {
    margin-bottom: 35px;
  }

  .article-heading:after {
    content: "";
    display: inline-block;
    clear: both;
  }

  a {
    color: rgba(255, 68, 177, 0.5);
  }

  a:hover {
    color: rgba(122, 255, 133, 0.47);
  }

  a:active {
    color: #92dfff;
  }

  span:hover {
    background-color: #d2e0ff;
  }

  span:active {
    background-color: #DCDFE6;
    color: #2aa4aa;
  }

  .footing {
    margin-top: 90px;
    text-shadow: #efffe6 1px 0px;
    padding: 5px;
  }
</style>
