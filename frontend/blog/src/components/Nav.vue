<template>
<!--  导航栏-->
  <div id="nav">
      <div class="nav">
        <a href="/"><span>Home</span></a>
        <a href="/tag"><span>Tag</span></a>
        <a href="/time"><span>Time</span></a>
        <a href="/about"><span>About</span></a>
      </div>
  </div>
</template>

<script>
    export default {
        name: "nav"
    }
</script>

<style scoped>

  * {
    padding: 0;
    margin: 0;
  }

  span {
    display: block;
    text-align: center;
  }

  .nav {
    display: flex;
    position: absolute;
    right: 15%;
    top: 10px;
  }

  /*伪元素*/
  .nav:after, .nav:before {
    margin-top: 0.5em;
    content: "";
    display: flex;
    border: 1.5em solid #fff;
  }

  .nav:after {
    border-right-color: transparent;
  }

  .nav:before {
    border-left-color: transparent;
  }

  .nav a:link, .nav a:visited {
    color: #ffbac4;
    text-decoration: none;
    height: 3.5em;
    overflow: hidden;
  }

  .nav span {
    background: #fff;
    display: inline-block;
    line-height: 3em;
    padding: 0 1.5em;
    margin-top: 0.5em;
    position: relative;
    -webkit-transition: background-color 0.2s, margin-top 0.2s;
    /* Saf3.2+, Chrome */
    -moz-transition: background-color 0.2s, margin-top 0.2s;
    /* FF4+ */
    -ms-transition: background-color 0.2s, margin-top 0.2s;
    /* IE10 */
    -o-transition: background-color 0.2s, margin-top 0.2s;
    /* Opera 10.5+ */
    transition: background-color 0.2s, margin-top 0.2s;
  }

  .nav a:hover span {
    background: #faf1f4;
    margin-top: 0;
  }

  .nav span:before {
    content: "";
    position: absolute;
    top: 3em;
    left: 0;
    border-right: 0.5em solid #9B8651;
    border-bottom: 0.5em solid #fff;
  }

  .nav span:after {
    content: "";
    position: absolute;
    top: 3em;
    right: 0;
    border-left: 0.5em solid #9B8651;
    border-bottom: 0.5em solid #fff;
  }
</style>
