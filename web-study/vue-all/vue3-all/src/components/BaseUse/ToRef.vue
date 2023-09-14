<template>
    {{ nameRef }}
</template>
<script>
import { onBeforeUnmount, reactive, toRef } from 'vue';
function refImpl(val) {
    const wrapper = {
        value: typeof val === "object" && val !== null ? reactive(val) : val
    }
}
function toRefImpl(object, key) {
    const wrapper = {
        get value() {
            return object[key]
        },
        set value(val) {
            object[key] = val
        }
    }
    return wrapper
}
function toRefsImpl(obj) {
    const ret = {}
    for (const key in obj) {
        ret[key] = toRefImpl(obj, key)
    }
    return ret
}
export default {
    setup() {
        let info = reactive({
            name: "小明"
        })
        let nameRef = toRef(info, "name")
        let timer = setTimeout(() => {
            nameRef.value = "小张"
        }, 1500)
        timer = setTimeout(() => {
            info.name = "小明2"
        }, 3000)
        onBeforeUnmount(() => {
            clearTimeout(timer)
        })
        return {
            nameRef
        }
    }
}
</script>