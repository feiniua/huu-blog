<template>
<!--  关于页-->
    <div id="about">
      <div class="wrapper">
        <Nav></Nav>
        <div class="content">
          <span>星空</span>
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
    min-height: 500px;
    background-color: #b0b9b7;
    margin: 0 auto;
    position: relative;
    top: 80px;
    padding-bottom: 80px;
    opacity: 0;
  }
  .content span {
    position: relative;
    top: 150px;
    font-family: cursive;
    padding-bottom: 20px;
    font-size: 23px;
    font-weight: bold;
  }
  .footing {
    padding: 5px;
    position: relative;
    top: 85px;
  }
</style>
