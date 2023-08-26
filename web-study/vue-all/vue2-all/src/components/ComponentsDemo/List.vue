<template>
    <div>
        <ul>
            <li v-for="(item, index) in list" :key="item">{{ item }}<span @click="del(index)">删除这个</span></li>
        </ul>
    </div>
</template>
<script>
import event from "./event"
export default {
    props: {
        list: {
            type: Array,
            default() {
                return []
            }
        }
    },
    data() {
        return {}
    },
    methods: {
        del(index) {
            // 自定义事件
            event.$emit("listDelItem", index)
        }
    },
    beforeCreate() { console.log("List beforeCreate") },
    created() { console.log("List created") },
    beforeMount() { console.log("List beforeMount") },
    mounted() { console.log("List mounted") },
    beforeUpdate() { console.log("List beforUpdate") },
    updated() { console.log("List update") },
    beforeDestroy() { console.log("List beforeDestroy") },
    destroyed() { console.log("List destroyed") }
}
</script>