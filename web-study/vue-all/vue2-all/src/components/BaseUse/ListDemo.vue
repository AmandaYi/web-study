<template>
    <div>
        <ul>
            <li v-for="(item) in toDoList" :key="item.id">{{ item.name }}</li>
        </ul>
        <ul>
            <li v-for="(value, key, index) in info" :key="value.id">{{ key }} - {{ value }}</li>
        </ul>
    </div>
</template>
<script>
export default {
    data() {
        return {
            toDoList: [
                {
                    id: 1, name: "晴天"
                },
                {
                    id: 2, name: "雨天"
                },
                {
                    id: 3, name: "多云"
                },
                {
                    id: 4, name: "大雨"
                },
                {
                    id: 5, name: "晴天"
                }
            ],
            info: {
                id: "1",
                name: "math",
                source: "100"
            }
        }
    }
}
</script>