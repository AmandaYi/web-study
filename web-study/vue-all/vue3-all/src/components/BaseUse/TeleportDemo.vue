<template>
    <button @click="showModal = true">打开</button>
    <Teleport to="body" v-if="showModal">
        <div>你好Modal</div>
        <button @click="showModal = false">关闭</button>
    </Teleport>
</template>
<script>
import { ref } from 'vue'
export default {
    setup() {
        let showModal = ref(false)
        return { showModal }
    }
}
</script>