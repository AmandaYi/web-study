<template>
    {{ name }} - {{ source }}
    <VModelChildren v-model:name="name" v-model:source="source"></VModelChildren>
</template>
<script>
import { ref } from 'vue';
import VModelChildren from './VModelChildren.vue';

export default {
    components: { VModelChildren },
    setup() {
        let name = ref("")
        let source = ref("")
        return {
            name, source
        }
    }
}
</script>