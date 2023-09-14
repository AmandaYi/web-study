<template>
    lifecycles
</template>
<script>
import { onDeactivated, onActivated, onBeforeMount, onBeforeUnmount, onBeforeUpdate, onMounted, onUnmounted, onUpdated } from 'vue'


export default {
    setup() {
        onBeforeMount(() => { console.log("onBeforeMount") })
        onMounted(() => { console.log("onMounted") })
        onBeforeUpdate(() => { console.log("onBeforeUpdate") })
        onUpdated(() => { console.log("onUpdated") })
        onBeforeUnmount(() => { console.log("onBeforeUnmount") })
        onUnmounted(() => { console.log("onUnmounted") })
        onDeactivated(() => { console.log("onDeactivated") })
        onActivated(() => { console.log("onActived") })
    },
    beforeCreate() {
        console.log("beforCreate")
    },
    created() {
        console.log("created")
    },
    beforeMount() {
        console.log("beforMount")
    },
    mounted() {
        console.log("mounted")
    },
    beforeUpdate() {
        console.log("update")
    },
    updated() {
        console.log("updated")
    },
    beforeActive() {
        console.log("beforeActive")
    },
    avtived() {
        console.log("actived")
    },
    beforeUnmount() {
        console.log("beforUnmount")
    },
    unmounted() {
        console.log("unmounted")
    }
}
</script>