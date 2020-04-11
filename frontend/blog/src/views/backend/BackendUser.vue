<template>
  <div class="backend-user">
    <el-page-header @back="goBack" content="用户管理">
    </el-page-header>
  </div>
</template>

<script>
  export default {
    name: "BackendUser",
    methods: {
      goBack: function () {
        // this.$router.go(-1);
        this.$router.push('/backend');
      }
    }
  }
</script>

<style scoped>

</style>
