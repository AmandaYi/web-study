<template>
    <div>
        <keep-alive>
            <h1 v-if="showMixinDemo">MixinDemo</h1>
        </keep-alive>
        <button @click="showMixinDemo = true">展示MixinDemo</button>
        <button @click="showMixinDemo = false">隐藏MixinDemo</button>
    </div>
</template>
<script>
import Mixin from './Mixin';
export default {
    mixins: [Mixin],
    data() {
        return { showMixinDemo: false }
    },
    created() {
        console.log("MixinDemo creadted")
    },
    mounted() {
        console.log("MixinDemo mounted")
    },
    activated() {
        console.log("MixinDemo activated")
    }
}
</script>