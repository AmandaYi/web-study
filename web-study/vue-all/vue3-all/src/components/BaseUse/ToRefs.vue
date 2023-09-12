<template>
    {{ name }}
</template>
<script>
import { reactive, toRefs } from 'vue';
function useFeatureX(params) {
    const state = reactive({
        x: 1,
        y: 2
    })
    // 返回时转换为ref
    return toRefs(state)
}
export default {
    setup() {
        // 这样子可以不丢失响应式进行解构值
        const { x, y } = useFeatureX()

        const state = reactive({
            name: "小明"
        })
        const d = toRefs(state)

        setTimeout(() => {
            d.name.value = "小明2"

        }, 1500);
        setTimeout(() => {
            console.log("state", state)
        }, 3000);
        return d
    }
}
</script>
 