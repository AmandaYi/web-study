<template>
    <div>
        <Input @add="add" />
        <List :list="list" />
    </div>
</template>
<script>
import Input from "./Input.vue"
import List from "./List.vue"
import event from "./event"
export default {
    components: {
        Input,
        List
    },
    data() {
        return {
            list: []
        }
    },
    beforeCreate() {
        console.log("index beforeCreate")
    },
    created() {
        console.log("index created")
    },
    beforeMount() {
        console.log("index beforeMount")
    },
    mounted() {
        console.log("index mounted")
        event.$on("listDelItem", this.del)
    },
    beforeUpdate() {
        console.log("index beforUpdate")
    },
    updated() {
        console.log("index update")
    },
    beforeDestroy() {
        console.log("index beforDestroy")
        event.$off("listDelItem", this.del)
    },
    destroyed() {
        console.log("index destroyed")
    },
    methods: {
        add(text) {
            this.list.push(text)
        },
        del(index) {
            this.list.splice(index, 1)
        }
    }
}
</script>