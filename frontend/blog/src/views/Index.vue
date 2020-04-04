<template>
    <div id="index">
      <Nav/>
      <img class="heading-img" src="static/img/index.jpg">
      <div v-for="(article,index) in message">
        <div class="article-body">
          <left-article :article="article" v-if="index % 2 ===0"></left-article>
          <right-article :article="article" v-if="index % 2 !==0"></right-article>
        </div>
      </div>
    </div>
</template>

<script>
    import Nav from "../components/Nav";
    import LeftArticle from "../components/LeftArticle";
    import RightArticle from "../components/RightArticle";

    export default {
        name: "index",
        components: {
          RightArticle,
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
              url: 'http://localhost:8091/api/article/all'
            }).then(function (response) {
              that.message = response.data.data.content;
            })
          }
        },
        data() {
          return {
            message: {}
          }
        }
    }
</script>

<style scoped>
  .heading-img {
    width: 100%;
    margin-bottom: 150px;
  }
</style>
