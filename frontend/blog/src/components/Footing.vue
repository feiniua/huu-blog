<template>
<!--  脚部组件-->
  <div class="footing">
    <div class="wrapper">
      <span class="title"><router-link to="/login"><i class="el-icon-star-off"></i>wenwuyou@foxmail.com</router-link></span>
      <br/>
      <i class="el-icon-time"></i>
      <span class="time">{{date}}</span>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Footing",
        // 设置计时器
        mounted() {
          this.clear=setInterval(() => {
            this.initDate();
          }, 1000)
        },
        // 页面关闭时清除计时器
        beforeDestroy() {
          clearInterval(this.clear);
        },
        methods: {
          initDate: function () {
            this.date = this.formatDate(new Date());
          },
          // 事件格式化
          formatDate: function (date) {
            let year = date.getFullYear();
            let month = date.getMonth() + 1;
            let day = date.getDate();
            let hours = date.getHours();
            let minutes = date.getMinutes();
            let seconds = date.getSeconds();
            let week = "星期" + "日一二三四五六".charAt(date.getDay());
            if (hours < 10) {
              hours = "0" + hours;
            }
            if (minutes < 10) {
              minutes = "0" + minutes;
            }
            if (seconds < 10) {
              seconds = "0" + seconds;
            }
            return year + "年" + month + "月" + day + "日 \| " + week + " \| " + hours + ":" + minutes + ":" + seconds;
          }
        },
        data() {
          return {
            date: "~~~~~~~~~~~~~~~~~~"
          }
        }
    }
</script>

<style scoped>
  .wrapper {
    position: relative;
    height: 55px;
    width: 100%;
    opacity: 0.9;
  }
  .wrapper .title {
    font-size: 14px;
  }
  .wrapper .time {
    color: #515d60;
    font-size: 11px;
  }
  a {
    color: #24272e;
  }
  a:hover {
    color: #446773;
  }
</style>
