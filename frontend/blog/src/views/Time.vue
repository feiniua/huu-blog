<template>
    <div id="time">
      <div class="wrapper">
        <Nav></Nav>
        <h1>time</h1>
      </div>
    </div>
</template>

<script>
    import Nav from "../components/Nav";
    export default {
        name: "Time",
        components: {
          Nav
        }
    }
</script>

<style scoped>
  .wrapper {
    width: 100%;
    background-color: #ffbac4;
  }
</style>
