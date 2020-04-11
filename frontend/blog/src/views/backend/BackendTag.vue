<template>
  <div class="backend-tag">
    <el-page-header @back="goBack" content="标签管理">
    </el-page-header>
  </div>
</template>

<script>
  export default {
    name: "BackendTag",
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
