<template>
    <div id="index">
      <Nav/>
      <img class="heading-img" src="static/img/index.jpg">
      <div class="content">
        <div class="article-body" v-for="(article,index) in articles">
          <left-article :article="article"></left-article>
        </div>
        <el-pagination
          small
          layout="prev, pager, next"
          :page-size="8"
          :total="totalElements"
          :background=true
          @current-change="getPage"
        >
        </el-pagination>
      </div>

    </div>
</template>

<script>
    import Nav from "../components/Nav";
    import LeftArticle from "../components/LeftArticle";

    export default {
        name: "index",
        components: {
          LeftArticle,
          Nav
        },
        beforeRouteEnter: (to,from, next) => {
          console.log("开始获取数据");
          next(vm => vm.getData())
        },
        methods: {
          getData: function () {
            let that = this
            this.axios({
              method: 'get',
              url: 'http://localhost:8091/api/article/all',
              params: {
                pageNumber: "0"
              },
            }).then(function (response) {
              that.articles = response.data.data.content;
              that.totalElements = response.data.data.totalElements;
              that.totalPages = response.data.data.totalPages;
              that.pageNumber = response.data.data.pageNumber;
            })
          },
          getPage: function (size) {
            let curNum = size - 1;
            let that = this
            this.axios({
              method: 'get',
              url: 'http://localhost:8091/api/article/all',
              params: {
                pageNumber: curNum
              },
            }).then(function (response) {
              that.articles = response.data.data.content;
              that.totalElements = response.data.data.totalElements;
              that.totalPages = response.data.data.totalPages;
              that.pageNumber = response.data.data.pageNumber;
              console.log(that.pageNumber);
            })
          }
        },
        data() {
          return {
            articles: {},
            totalElements: 0,
            totalPages: 0,
            pageNumber: 0
          }
        }
    }
</script>

<style scoped>
  .heading-img {
    width: 100%;
  }
  .content {
    border-radius: 15px;
    width: 90%;
    background-color: #DCDFE6;
    padding-top: 50px;
    padding-bottom: 20px;
    margin: 60px auto 50px;
    opacity: 0.9;
  }
</style>
