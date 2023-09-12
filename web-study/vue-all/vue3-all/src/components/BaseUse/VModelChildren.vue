<template>
    <input :value="name" @input="$emit('update:name', $event.target.value)">
    <input :value="source" @input="$emit('update:source', $event.target.value)">
</template>
<script>
export default {
    props: {
        name: String,
        source: String
    },
    emits: ["update:name", "update:source"],
    setup() {

    }
}
</script>