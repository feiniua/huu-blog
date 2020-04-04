<template>
  <div id="leftArticle">
    <div class="wrapper">
      <a href=""><img class="article-img" :src="article.imageAddress"></a>
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
    clear: both;
  }
  .wrapper {
    width: 80%;
    margin: 0 auto;
  }
  .article-img {
    width: 55%;
    height: auto;
    float: left;
    margin-bottom: 150px;
    padding-right: 50px;
  }
  .article-body {
    width: 35%;
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
    color: #929db1;
  }
  .article-body .article-heading .createTime:active {
    color: #7576b1;
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
    color: #a4b8a2;
  }
  a:hover {
    color: #84b17c;
  }
  a:active {
    color: #87d57d;
  }
</style>
