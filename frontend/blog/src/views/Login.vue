<template>
    <div id="login">
      <div class="wrapper">
        <div class="content">
          <div class="back">
            <router-link to="/"><i class="el-icon-back"></i></router-link>
          </div>
          <label class="username">
            <i class="el-icon-user"></i>
            <input type="text" name="username" placeholder="Username"/>
          </label>
          <label class="password">
            <i class="el-icon-edit"></i>
            <input type="password" name="password" placeholder="Password"/>
          </label>
          <button class="btn">登录</button>
          <Footing class="footing"></Footing>
        </div>
        <img class="background" src="../../static/img/login.jpg"/>
      </div>
    </div>
</template>

<script>
    import Footing from "../components/Footing";
    export default {
        name: "Login",
      components: {Footing}
    }
</script>

<style scoped>
  .back {
    position: absolute;
    font-size: 20px;
    top: 5%;
    left: 8%;
  }
  .content {
    width: 400px;
    height: 250px;
    background-color: #00000060;
    position: relative;
    top: 280px;
    left: 50%;
    margin-top: -125px;
    margin-left: -200px;
    opacity: 0.7;
  }
  .content i {
    color: #DCDFE6;
  }
  .content i:hover {
    color: #2aa4aa;
  }
  .content input {
    height: 20px;
    background-color: #00000060;
    outline: none;
    border: 0;
    border-bottom: #DCDFE6 solid 2px;
    padding: 5px 10px;
    margin-bottom: 10px;
    color: #DCDFE6;
  }
  .username {
    position: absolute;
    top: 35%;
    left: 26%;
  }
  .password {
    position: absolute;
    top: 50%;
    left: 26%;
  }
  .btn {
    width: 60px;
    background-color: #00000080;
    border: 0;
    border-radius: 5px;
    outline: none;
    position: absolute;
    left: 172px;
    top: 72%;
  }
  .btn:active {
    background-color: #DCDFE6;
  }

  .background {
    position: fixed;
    top: 0;
    left: 0;
    z-index: -2;
    width: 100%;
    height: 120%;
  }
  .footing {
    position: absolute;
    bottom: -60px;
    left: 28%;
  }
</style>
