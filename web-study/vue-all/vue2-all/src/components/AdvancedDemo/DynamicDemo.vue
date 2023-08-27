<template>
    <div>
        <component :is="DyTag"></component>
    </div>
</template>

<script>
import DyTag from './DyTag.vue';

export default {
    components:{
        DyTag
    },
    data() {
        return {}
    }
}
</script>