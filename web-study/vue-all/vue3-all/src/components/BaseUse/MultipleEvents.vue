<template>
    <button @click="onPrint(), onSayhi()">多事件处理</button>
</template>
<script>
export default {
    setup() {
        function onPrint() {
            console.log("onPrint")
        }
        function onSayhi() {
            console.log("onSayhi")
        }
        return {
            onPrint,
            onSayhi
        }
    }
}
</script>