<template>
  <div class="editArticle">
    <mavon-editor v-model="message"></mavon-editor>
  </div>
</template>

<script>
  export default {
    name: "EditArticle",
    data() {
      return {
        message: ""
      }
    }
  }
</script>

<style scoped>

</style>
