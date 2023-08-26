<template>
    <div>
        <p>
            watch数量:<input type="text" v-model="count" />
        </p>
        <p>动态监测结果:{{ message }}</p>
        <p @click="changeWTmp">改变wTmp的值</p>
    </div>
</template>
<script>
let wTmp = 0
export default {
    data() {
        return {
            count: 0,
            message: "",
            info: {
                key: ""
            }
        }
    },
    methods: {
        changeWTmp() {
            wTmp = 100
        }
    },
    watch: {
        count: {
            handler(newValue, oldValue) {
                this.message = `新值${newValue},旧值:${oldValue}`
            }
        },
        info: {
            handler(newValue, oldValue) {

            },
            deep: true
        },
        // 如果这个值并不是响应式的，那么是无法监听到的
        wTmp: {
            handler(newValue, oldValue) {
                this.message = `新值${newValue},旧值:${oldValue}`
            }
        }
    }
}
</script>