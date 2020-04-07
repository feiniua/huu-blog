<template>
<!--  关于页-->
    <div id="about">
      <div class="wrapper">
        <Nav></Nav>
        <div class="content"></div>
        <Footing class="footing"></Footing>
<!--        背景图片-->
        <img class="background" src="/static/img/about.jpg"/>
      </div>
    </div>
</template>

<script>
    import Nav from "../components/Nav";
    import Footing from "../components/Footing";
    export default {
        name: "About",
        components: {
          Footing,
          Nav
        }
    }
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }
  .wrapper .content {
    width: 70%;
    min-height: 500px;
    background-color: #aaa483;
    margin: 0 auto;
    position: relative;
    top: 80px;
    padding-bottom: 80px;
    opacity: 0.8;
  }
  .background {
    width: 100%;
    height: 120%;
    position: fixed;
    top: 0;
    left: 0;
    z-index: -1;
  }
  .footing {
    padding: 5px;
    position: relative;
    top: 85px;
  }
</style>
