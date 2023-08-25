<template>
  <!-- <TplDemo></TplDemo> -->
  <ComputedDemo></ComputedDemo>
  <!-- <WatchDemo></WatchDemo> -->
</template>

<script>
// import TplDemo from './components/BaseUse/TplDemo.vue';
import ComputedDemo from './components/BaseUse/ComputedDemo.vue';
import WatchDemo from './components/BaseUse/WatchDemo.vue';
export default {
  name: 'App',
  components: {
    // TplDemo
    ComputedDemo,
    // WatchDemo
  }
}
</script>