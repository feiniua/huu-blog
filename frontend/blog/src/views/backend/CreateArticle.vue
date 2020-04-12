<template>
  <div class="createArticle">
    <div class="wrapper">
      <div class="heading">
        <span>
          <i class="el-icon-close" style="color: #ff5353" v-if="title.length === 0"></i>
          <i class="el-icon-check" style="color: #369d49" v-else></i>
          Title: </span><input class="title" type="text" v-model="title"></input>
      </div>
      <mavon-editor v-model="content"
                    ref="md"
                    @imgAdd="$imgAdd"
                    @imgDel="$imgDel">

      </mavon-editor>
      <div class="footing">
        <button class="tagBtn">文章标签</button>
        <br/>
        <div class="upload">
          <input class="background-img" type="file" name="file" @change="changeFile($event)">
          <i class="el-icon-close" style="color: #ff5353" v-if="this.file.length === 0"></i>
          <i class="el-icon-check" style="color: #369d49" v-else></i>
          <span>{{fileSpan}}</span>
        </div>
        <button class="submit" v-on:click="createArticle">提交</button>
      </div>
    </div>
  </div>
</template>

<script>
  import UrlInfo from "../../config/UrlInfo";


  export default {
    name: "CreateArticle",
    methods: {
      createArticle: function () {
        let that = this;
        let formData = new FormData();
        formData.append('file', that.file);
        formData.append('title', that.title);
        formData.append('content', that.content);
        console.log(that.file)
        this.axios({
          method: 'post',
          data: formData,
          url: UrlInfo.url + "api/article",
          processData: false,
          contentType: false
        }).then(function (response) {
          that.$message({
            type: 'info',
            message: `success: 添加成功`
          });
          that.$router.push({name: 'vb-article'})
        }).catch(function (error) {
          // 调用失败后返回提示
          that.$alert(error.response.data.msg, '错误', {
            confirmButtonText: '确定'
          })
        })
      },
      changeFile: function (e) {
        this.file = e.target.files[0];
        this.fileSpan = e.target.files[0].name;
      },
      $imgAdd(pos, $file) {
        let that = this;
        let formData = new FormData();
        formData.append('file', $file);
        // 第一步发送请求返回url
        this.axios({
          method: "post",
          url: UrlInfo.url + 'api/image',
          data: formData,
          headers: {'Content-Type': 'multipart/form-data'}
        }).then(function (response) {
          // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
          that.$refs.md.$img2Url(pos, response.data.data);
        }).catch(function (error) {
          that.$alert(error.response.data.msg, '错误', {
            confirmButtonText: '确定'
          })
        })
      },
      $imgDel(pos) {
        delete this.img_file[pos];
      }
    },
    data() {
      return {
        content: "",
        title: "",
        file: "",
        fileSpan: "背景图片"
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
    outline: none;
    border: 0;
    border-radius: 5px;
    color: #DCDFE6;
    background-color: #7d7979;
    margin-right: 3px;
    padding: 2px;
  }
  button:hover {
    background-color: #96aaa7;
  }
  button:active {
    color: #7d7979;
    background-color: #DCDFE6;
  }
  .wrapper {
    min-height: 550px;
  }
  .heading {
    position: relative;
    top: -10px;
    left: -400px;
  }
  .title {
    outline: none;
    border: 0;
    height: 20px;
    margin-right: 20px;
    background-color: #98999e;
    padding: 3px;
  }
  .footing {
    margin-top: 10px;
    position: absolute;
  }
  .background-img {
    outline: none;
    border: 0;
    width: 63px;
    overflow: hidden;
    opacity: 0;
    background-color: #00000060;
    position: absolute;
  }
  .upload {
    margin-top: 10px;
    margin-left: 20px;
  }
  .upload span {
    color: #DCDFE6;
    background-color: #7a6ba0;
    padding: 3px;
    border-radius: 4px;
  }
  .upload span:hover {
    color: #7a6ba0;
    background-color: #DCDFE6;
  }
  .tagBtn {
    position: relative;
    left: 820px;
    top: 20px;
    font-size: 16px;
  }
  .submit {
    position: relative;
    left: 850px;
    font-size: 20px;
    background-color: #6fbf85;
  }
  .submit:hover {
    background-color: #DCDFE6;
    color: #6fbf85;
  }
  .submit:active {
    background-color: #00000000;
  }
</style>
