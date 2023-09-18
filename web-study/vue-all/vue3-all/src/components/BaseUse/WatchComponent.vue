<template>
    watch
</template>
<script>
import { onBeforeUnmount, onMounted, reactive, watch } from 'vue';

export default {
    setup() {
        let timer = null
        let info = reactive({
            name: "小明"
        })
        watch(() => info.name, (newName, oldName) => {
            console.log("newName:", newName, "oldName", oldName)
        }, {
            immediate: true, // 第一次加载的时候就监听
            deep: true // 深度监听
        })
        onMounted(() => {
            timer = setTimeout(() => {
                info.name = "小张"
            }, 1500)
        })

        onBeforeUnmount(() => {
            clearTimeout(timer)
        })
    }
}
</script>