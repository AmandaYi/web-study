<template>
  <!-- <TplDemo></TplDemo> -->
  <!-- <ComputedDemo></ComputedDemo> -->
  <!-- <WatchDemo></WatchDemo> -->
  <!-- <ConditionDemo></ConditionDemo> -->
  <!-- <ListDemo></ListDemo> -->
  <!-- <EventDemo></EventDemo> -->
  <!-- <FormDemo></FormDemo> -->
  <!-- <ComponentsDemo></ComponentsDemo> -->
  <AdvancedDemo></AdvancedDemo>
</template>

<script>
import TplDemo from './components/BaseUse/TplDemo.vue';
import ComputedDemo from './components/BaseUse/ComputedDemo.vue';
import WatchDemo from './components/BaseUse/WatchDemo.vue';
import ConditionDemo from './components/BaseUse/ConditionDemo.vue';
import EventDemo from './components/BaseUse/EventDemo.vue';
import ListDemo from './components/BaseUse/ListDemo.vue';
import FormDemo from './components/BaseUse/FormDemo.vue';
import ComponentsDemo from "./components/ComponentsDemo/index.vue"
import AdvancedDemo from "./components/AdvancedDemo/index.vue"
export default {
  name: 'App',
  components: {
    TplDemo,
    ComputedDemo,
    WatchDemo,
    ConditionDemo,
    ListDemo,
    EventDemo,
    FormDemo,
    ComponentsDemo,
    AdvancedDemo
  }
}
</script>