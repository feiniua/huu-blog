<template>
<!--  关于页-->
    <div id="about">
      <div class="wrapper">
        <Nav></Nav>
        <div class="content">
          <span>追寻星空大海</span>
        </div>
        <Footing class="footing"></Footing>
<!--        背景图片-->
        <Star class="star"></Star>
      </div>
    </div>
</template>

<script>
    import Nav from "../components/Nav";
    import Footing from "../components/Footing";
    import Star from "../components/Star";
    export default {
        name: "About",
        components: {
          Footing,
          Nav,
          Star
        }
    }
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }
  .star {
    position: fixed;
    z-index: -1;
  }
  .wrapper .content {
    width: 70%;
    min-height: 600px;
    /*background-color: #b0b9b7;*/
    margin: 0 auto;
    position: relative;
    top: 80px;
    padding-bottom: 80px;
  }
  .content span {
    position: relative;
    top: 200px;
    font-family: cursive;
    padding-bottom: 20px;
    font-size: 23px;
    font-weight: bold;
    color: #0f3d2a;
    -webkit-user-select:none;
    -moz-user-select:none;
    -ms-user-select:none;
  }
  .footing {
    padding: 5px;
    position: relative;
    top: 85px;
  }
</style>
