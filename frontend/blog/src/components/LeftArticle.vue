<template>
  <div id="leftArticle">
    <div class="wrapper">
      <router-link :to="{name: 'v-article', params: {id: article.id}}"><img class="article-img" :src="article.imageAddress"></router-link>
      <div class="article-body">
        <div class="article-heading">
          <router-link to="/time" class="createTime">{{getDate(article.createAt)}}</router-link>
          <div v-for="tag in article.tags">
            <router-link :to="{name: 'v-tag', params: {name: tag.name}}"><el-tag class="tag" type="success">{{tag.name}}</el-tag></router-link>
          </div>
        </div>
        <h2 class="title"><router-link :to="{name: 'v-article', params: {id: article.id}}">{{article.title}}</router-link></h2>
        <span>{{article.content}}</span>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        props: ['article'],
        name: "LeftArticle",
        methods: {
          getDate: function (date) {
            let year = date.substring(0,4);
            let month = date.substring(5,7);
            let day = date.substring(8,10);
            let time = date.substring(11,19);
            return year + '-' + month + '-' + day + " " + time;
          }
        }
    }
</script>

<style scoped>
  #leftArticle {
    height: auto;
    width: auto;
  }
  .wrapper:after {
    content: "";
    display: block;
    clear: both;
  }
  .wrapper {
    width: 90%;
    height: auto;
    background-color: #EBEEF5;
    padding: 50px;
    margin: 0 auto 10px;
    border-radius: 20px;
  }
  .article-img {
    width: 55%;
    height: auto;
    float: left;
    padding-right: 50px;
  }
  .article-body {
    width: 37%;
    float: left;
    text-align: center;
    margin-top: -15px;
    position: relative;
  }
  .article-body .article-heading {
    width: 100%;
    position: absolute;
    top: 68px;
  }
  .article-body .article-heading .createTime {
    top: 60px;
    float: left;
    margin-left: -20px;
    line-height: 100%;
  }
  .article-body .article-heading .createTime:hover {
    color: rgba(136, 255, 121, 0.35);
  }
  .article-body .article-heading .createTime:active {
    color: rgba(89, 255, 29, 0.55);
  }
  .article-body .article-heading .tag {
    float: right;
    margin-left: 5px;
    margin-top: -10px;
  }
  .article-body .title {
    width: 100%;
    height: 60px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
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
</style>
