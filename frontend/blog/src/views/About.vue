<template>
    <div id="about">
      <div class="wrapper">
        <Nav></Nav>
        <h1>about</h1>
      </div>
    </div>
</template>

<script>
    import Nav from "../components/Nav";
    export default {
        name: "About",
        components: {
          Nav
        }
    }
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }
  .wrapper {
    height: 600px;
    background-size: 100% 100%;
    background-image: url("../../static/img/about.png");
  }
</style>
