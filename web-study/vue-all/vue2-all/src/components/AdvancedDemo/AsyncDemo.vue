<template>
    <div>
        <AsyncTag v-if="showAsyncTag"></AsyncTag>
        <button @click="showAsyncTag = true">展示异步组件</button>
    </div>
</template>
<script>
export default {
    components: {
        AsyncTag: () => import("./AsyncTag.vue")
    },
    data() {
        return { showAsyncTag: false }
    }
}
</script>