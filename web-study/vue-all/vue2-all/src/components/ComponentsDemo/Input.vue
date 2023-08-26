<template>
    <div>
        <input type="text" v-model="title" />
        <span @click="add">Add</span>
    </div>
</template>
<script>
export default {

    data() {
        return {
            title: ""
        }
    },
    methods: {
        add() {
            // 广播出去
            this.$emit("add", this.title)
            this.title = ""
        },
    }, 
}
</script>