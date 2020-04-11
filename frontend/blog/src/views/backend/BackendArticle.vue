<template>
  <div class="backend-article">
    <div class="wrapper">
      <el-page-header @back="goBack" content="文章管理"></el-page-header>
      <el-divider class="divider1"></el-divider>
      <div class="heading">
        <input class="findtext" type="text"></input>
        <button class="findbtn">查询</button>
        <button class="createbtn" @click="createArticle">新建文章</button>
      </div>
      <div class="content">
        <div class="body" v-for="item in articles">
          <router-link :to="{name: 'v-article', params:{id: item.id}}">
            <span class="createTime">{{formatDate(item.createAt)}}</span>
            <span class="title">{{item.title}}</span>
          </router-link>
          <button class="deletebtn" @click="deleteArticle(item.id)">删除</button>
          <button class="editbtn">编辑</button>
        </div>
      </div>
      <div class="pageing">
        <el-pagination
          small
          background
          layout="prev, pager, next"
          :total="this.totalElements"
          :page-size="this.pageSize"
          :hide-on-single-page=true
          @current-change="getPage"
        >
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
  import UrlInfo from "../../config/UrlInfo";

  export default {
    name: "BackendArticle",
    created() {
      let that = this;
      this.axios({
        method: 'get',
        url: UrlInfo.url + '/api/article/all'
      }).then(function (response) {
        that.articles = response.data.data.content;
        that.totalElements = response.data.data.totalElements;
        that.pageNumber = response.data.data.pageNumber;
        that.pageSize = response.data.data.pageSize;
      })
    },
    methods: {
      goBack: function () {
        // this.$router.go(-1);
        this.$router.push('/backend');
      },
      formatDate: function (date) {
        let year = date.substring(0, 4);
        let month = date.substring(5, 7);
        let day = date.substring(8, 10);
        let time = date.substring(11, 19);
        return year + '-' + month + '-' + day + " " + time;
      },
      getPage: function (size) {
        let curNum = size - 1;
        let that = this
        let url = UrlInfo.url;
        this.axios({
          method: 'get',
          url: url + 'api/article/all',
          params: {
            pageNumber: curNum
          },
        }).then(function (response) {
          that.articles = response.data.data.content;
          that.totalElements = response.data.data.totalElements;
          that.totalPages = response.data.data.totalPages;
          that.pageNumber = response.data.data.pageNumber;
        })
      },
      createArticle: function () {
        this.$router.push({name: 'vb-createArticle'})
      },
      deleteArticle: function (id) {
        let that = this;
        console.log(id);
        this.axios({
          method: 'delete',
          url: UrlInfo.url + 'api/article/' + id
        }).then(function (response) {
          // 调用成功
          that.$alert('删除成功', '提示', {
            confirmButtonText: '确定',
            beforeClose: function () {
              that.$router.go(0);
            }
          });
        }).catch(function (error) {
          // 调用失败后返回提示
          that.$alert(error.response.data.msg, '错误', {
            confirmButtonText: '确定'
          })
        })
      }
    },
    data() {
      return {
        articles: {},
        pageNumber: "",
        pageSize: "",
        totalElements: ""
      }
    }
  }
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }

  button {
    color: #63638b;
    background-color: #DCDFE6;
    outline: none;
    border: 0;
    border-radius: 2px;
  }

  button:hover {
    background-color: #777a8b;
    color: #DCDFE6;
  }

  button:active {
    background-color: #8b896a;
    color: #DCDFE6;
  }

  a {
    color: #35383b;
  }

  a:hover {
    color: rgba(133, 73, 129, 0.56);
  }

  a:active {
    color: #484a43;
  }

  .wrapper {
    width: 96%;
    padding: 10px;
    background-color: rgba(153, 162, 154, 0.33);
    min-height: 550px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)

  }

  .divider1 {
    margin-top: 15px;
  }

  .heading {
    width: 100%;
    padding-top: 20px;
    height: 25px;
  }

  .findtext {
    float: left;
    margin-left: 50px;
    outline: none;
    background-color: #00000060;
    border: 0;
    height: 25px;
    padding-left: 9px;
    border-radius: 10px;
  }

  .findbtn {
    margin-left: 10px;
    float: left;
    line-height: 23px;
    padding: 1px;
  }

  .createbtn {
    float: right;
    line-height: 23px;
    margin-right: 50px;
    padding: 2px;
  }

  .content {
    margin-top: 35px;
    margin-left: 50px;
    padding: 20px;
    background-color: rgba(175, 190, 173, 0.58);
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }

  .body {
    height: 20px;
    margin-bottom: 20px;
    width: 100%;
    padding-bottom: 2px;
    border-bottom: #222a4a solid 1px;
  }

  .body .createTime {
    float: left;
    font-size: 13px;
    line-height: 20px;
    padding-right: 20px;
    padding-top: 3px;
  }

  .body .title {
    float: left;
  }

  .editbtn {
    float: right;
    margin-right: 10px;
  }

  .deletebtn {
    float: right;
  }

  .pageing {
    margin-top: 30px;
  }

  .pageing button {
    background-color: #ffbac4;
  }
</style>
