<template>
    <Suspense>
        <template v-slot:default>
            <AsyncComponent></AsyncComponent>
        </template>
        <template v-slot:fallback>
            loading
        </template>
    </Suspense>
</template>
<script>
import { defineAsyncComponent } from 'vue';
export default {
    components: {
        AsyncComponent: defineAsyncComponent(() => import("./AsyncComponent.vue"))
    },
}
</script>