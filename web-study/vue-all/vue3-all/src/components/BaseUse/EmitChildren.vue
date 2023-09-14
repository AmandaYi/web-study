<template>
    <button @click="onSayHi">点击</button>
</template>
<script>
export default {
    emits: ["onSayHi"],
    setup(props, { emit }) {
        function onSayHi() {
            emit("onSayHi")
        }
        return {
            onSayHi
        }
    }
}
</script>