<template>
  <div class="backend-tag">
    <div class="wrapper">
      <el-page-header @back="goBack" content="标签管理">
      </el-page-header>
      <div class="createBtn">
        <button @click="create">新建标签</button>
      </div>
      <div class="content">
        <span class="tag" v-for="tag in tags.data">
          <button class="tagBtn" @click="open(tag.name)">{{tag.name}}</button>
          <button class="editBtn"><i class="el-icon-edit" @click="editTag(tag.id, tag.name)"></i></button>
          <button class="closeBtn"><i class="el-icon-close" @click="deleteTag(tag.id, tag.name)"></i></button>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
  import UrlInfo from "../../config/UrlInfo";

  export default {
    name: "BackendTag",
    created() {
      let that = this;
      this.axios({
        method: "get",
        url: UrlInfo.url + 'api/tag/all'
      }).then(function (response) {
        that.tags = response.data;
      })
    },
    methods: {
      create: function () {
        let that = this;
        this.$prompt('标签名', '新建', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({value}) => {
          that.axios({
            method: "post",
            url: UrlInfo.url + 'api/tag',
            data: {name: value},
          }).then(function (response) {
            // 如果后台返回状态为false
            if (!response.data.success) {
              that.$alert('添加失败：' + response.data.msg, '提示', {
                confirmButtonText: '确定',
                beforeClose: function () {
                  that.$router.go(0);
                }
              });
              return;
            }
            // 成功
            that.$alert('添加成功', '提示', {
              confirmButtonText: '确定',
              beforeClose: function () {
                that.$router.go(0);
              }
            });
          }).catch(function (error) {
            // 后台报错
            that.$alert(error.response.data.msg, '错误', {
              confirmButtonText: '确定'
            })
          });
        });
      },
      open: function (tagName) {
        this.$router.push({name: 'v-singleTag', params: {tagName: tagName}});
      },
      editTag: function (tagId, tagName) {
        let that = this;

        // 使用带有input的弹出框取tagname值
        this.$prompt('新命名', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputValue: tagName
          // inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
          // inputErrorMessage: '邮箱格式不正确'
        }).then(({value}) => {
          // 取值后发送请求
          that.axios({
            method: "put",
            url: UrlInfo.url + 'api/tag/' + tagId,
            data: {name: value},
          }).then(function (response) {
            // 如果后台返回状态为false
            if (!response.data.success) {
              that.$alert('修改失败：' + response.data.msg, '提示', {
                confirmButtonText: '确定',
                beforeClose: function () {
                  that.$router.go(0);
                }
              });
              return;
            }
            // 成功
            that.$alert('修改成功', '提示', {
              confirmButtonText: '确定',
              beforeClose: function () {
                that.$router.go(0);
              }
            });
          }).catch(function (error) {
            // 后台报错
            that.$alert(error.response.data.msg, '错误', {
              confirmButtonText: '确定'
            })
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });
        });
      },
      deleteTag: function (tagId, tagName) {
        let that = this;

        // 先发送请求查询标签是否有绑定文章
        that.axios({
          method: 'get',
          url: UrlInfo.url + 'api/article/byTagName',
          params: {
            tagName: tagName
          }
        }).then(function (response) {
          // 如果有则无法删除
          if (response.data.data.length !== 0) {
            that.$alert('删除失败：该标签下有' + response.data.data.length + '篇文章', '提示', {
              confirmButtonText: '确定'
            });
            return;
          }

          // 如果没有则删除
          that.axios({
            method: "delete",
            url: UrlInfo.url + 'api/tag/' + tagId,
          }).then(function (response) {
            that.$alert('删除成功', '提示', {
              confirmButtonText: '确定',
              beforeClose: function () {
                that.$router.go(0);
              }
            });
          }).catch(function (error) {
            that.$alert(error.response.data.msg, '错误', {
              confirmButtonText: '确定'
            })
          });
        });
      },
      goBack: function () {
        this.$router.go(-1);
        // this.$router.push('/backend');
      }
    },
    data() {
      return {
        tags: []
      }
    }
  }
</script>

<style scoped>
  button {
    border: 0;
    outline: none;
    background-color: #5398e4;
    color: #d6e6da;
    border-radius: 3px;
  }

  .wrapper {
    width: 96%;
    padding: 10px;
    background-color: rgba(153, 162, 154, 0.33);
    min-height: 550px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }

  .createBtn {
    position: absolute;
    right: 10%;
  }
  .createBtn button {
    background-color: #5c8161;
    color: #c1c4cb;
  }
  .createBtn button:hover {
    color: #5c8161;
    background-color: #c1c4cb;
  }

  .content {
    padding: 100px;
    margin: 0 auto;
    width: 50%;
  }

  .tag {
    height: 26px;
    margin-left: 40px;
    position: relative;
  }

  .tagBtn {
    height: 26px;
    line-height: 26px;
    margin-bottom: 20px;
  }

  .tagBtn:hover {
    background-color: #d6e6da;
    color: #5398e4;
  }

  .editBtn {
    padding: 0;
    position: absolute;
    width: 13px;
    height: 13px;
    top: 10px;
    background-color: #44a071;
  }

  .editBtn:hover {
    background-color: #d6e6da;
    color: #44a071;
  }

  .closeBtn {
    padding: 0;
    position: absolute;
    width: 13px;
    height: 13px;
    background-color: #b16a43;
  }

  .closeBtn:hover {
    background-color: #d6e6da;
    color: #b16a43;
  }
</style>
