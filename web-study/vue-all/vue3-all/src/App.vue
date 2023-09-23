<template>
  <!-- <LifeCycles></LifeCycles> -->
  <!-- <Ref></Ref> -->
  <!-- <ToRef></ToRef> -->
  <!-- <ToRefs></ToRefs> -->
  <!-- <Emits></Emits> -->
  <!-- <MultipleEvents></MultipleEvents> -->
  <!-- <VModel></VModel> -->
  <!-- <AsyncComponent></AsyncComponent> -->
  <!-- <TeleportDemo></TeleportDemo> -->
  <!-- <SuspenseDemo></SuspenseDemo> -->
  <!-- <MousePosition></MousePosition> -->
  <!-- <WatchComponent></WatchComponent> -->
  <!-- <WatchEffectComponent/> -->
  <!-- <HOCFactory></HOCFactory> -->
  <RouterDemo></RouterDemo>
</template>

<script>
import Ref from "./components/BaseUse/Ref.vue";
import ToRef from "./components/BaseUse/ToRef.vue";
import LifeCycles from "./components/LifeCycles.vue";
import ToRefs from "./components/BaseUse/ToRefs.vue";
import Emits from "./components/BaseUse/Emits.vue";
import MultipleEvents from "./components/BaseUse/MultipleEvents.vue";
import VModel from "./components/BaseUse/VModel.vue";
import { defineAsyncComponent } from "vue";
// import AsyncComponent from "./components/BaseUse/AsyncComponent.vue";
import TeleportDemo from "./components/BaseUse/TeleportDemo.vue";
import SuspenseDemo from "./components/BaseUse/SuspenseDemo.vue";
import MousePosition from "./components/MousePosition/index.vue"
import WatchComponent from "./components/BaseUse/WatchComponent.vue";
import WatchEffectComponent from "./components/BaseUse/WatchEffectComponent.vue"
import HOCFactory from "./components/BaseUse/HOCFactory"
import RouterDemo from "./components/RouterUse/index.vue"

export default {
  name: 'App',
  components: {
    WatchEffectComponent,
    LifeCycles,
    Ref,
    ToRef,
    ToRefs,
    Emits,
    MultipleEvents,
    VModel,
    AsyncComponent: defineAsyncComponent(() => import("./components/BaseUse/AsyncComponent.vue")),
    TeleportDemo,
    SuspenseDemo,
    MousePosition,
    WatchComponent,
    HOCFactory,
    RouterDemo
}
}
</script>
