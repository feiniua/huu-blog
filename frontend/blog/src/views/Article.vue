<template>
    <div id="article">
      <h2>文章页</h2>
      {{id}}
      {{message}}
    </div>
</template>

<script>
    export default {
        props: ['id'],
        name: "Article",
        created() {
          let id = this.$route.params.id;
          console.log(id);
          let that = this;
          this.axios({
            method: 'get',
            url: 'http://localhost:8091/api/article/' + id,
          }).then(function (response) {
            that.message = response.data.data;
          })
        },
        data() {
          return {
            message: {}
          }
        }
    }
</script>

<style scoped>

</style>
