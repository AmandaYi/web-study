<template>
  <text class="message">weex你好{{appName}}</text>
</template>
<script>
export default {
  data() {
    return {
      appName: ""
    };
  },
  created() {
    // console.log();
    this.appName = WXEnvironment.appName;
  }
};
</script>
