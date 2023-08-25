<template>
    <div>
        <p>
            watch数量:<input type="text" v-model="count" />
        </p>
        <p>动态监测结果:{{ message }}</p>
    </div>
</template>
<script>
export default {
    data() {
        return {
            count: 0,
            message: ""
        }
    },
    watch: {
        count: {
            handler(newValue, oldValue) {
                this.message = `新值${newValue},旧值:${oldValue}`
            }
        }
    }
}
</script>