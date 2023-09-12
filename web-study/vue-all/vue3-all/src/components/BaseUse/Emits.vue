<template>
    <EmitChildren @onSayHi="onSayHi"></EmitChildren>
</template>
<script>
import EmitChildren from './EmitChildren.vue';

export default {
    setup() {
        function onSayHi() {
            console.log("emit onSayHi")
        }
        return {
            onSayHi
        }
    },
    components: { EmitChildren }
}
</script>