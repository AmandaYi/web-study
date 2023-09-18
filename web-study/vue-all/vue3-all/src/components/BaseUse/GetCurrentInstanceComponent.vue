<template>
    getCurrentInstance
</template>
<script>
import { getCurrentInstance } from 'vue';


export default {
    setup() {
        // 获取当前的实例
        let that = getCurrentInstance()
        console.log(that)
    }
}


</script>