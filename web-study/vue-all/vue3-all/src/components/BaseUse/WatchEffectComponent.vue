<template>
    <p>WatchEffectComponent</p>
    <p>{{ info.name }}</p>
</template>
<script>
import { onBeforeUnmount, onMounted, reactive, watchEffect } from 'vue';

export default {
    name: "WatchEffectComponent",
    setup() {
        let timer = null
        let info = reactive({
            name: "小明"
        })
        let count = 0
        watchEffect(() => {
            // 强行不让第一次收集依赖
            if (count === 0) {
                count++
                return false
            }
            console.log(info.name)
        })
        onMounted(() => {
            timer = setTimeout(() => {
                info.name = "小张"
            }, 1500)
        })
        onBeforeUnmount(() => {
            clearTimeout(timer)
        })
        return {
            info
        }
    }
}
</script>