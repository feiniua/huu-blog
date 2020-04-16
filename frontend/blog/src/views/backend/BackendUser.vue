<template>
  <div class="backend-user">
    <div class="wrapper">
      <el-page-header @back="goBack" content="用户管理">
      </el-page-header>
    </div>
  </div>
</template>

<script>
  export default {
    name: "BackendUser",
    methods: {
      goBack: function () {
        this.$router.go(-1);
        // this.$router.push('/backend');
      }
    }
  }
</script>

<style scoped>
  .wrapper {
    width: 96%;
    padding: 10px;
    background-color: rgba(153, 162, 154, 0.33);
    min-height: 550px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
  }
</style>
