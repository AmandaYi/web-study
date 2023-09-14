function reactive(target = {}) {
    if (typeof target !== "object" || typeof target === null) {
        // 不是对象或者数组就返回
        return target
    }
    // 进行代理
    let proxyConfig = {
        get(target, key, receiver) {
            const ownKeys = Reflect.ownKeys(target)
            if (ownKeys.includes(key)) {
                console.log("更新视图")
            }
            const result = Reflect.get(target, key, receiver)
            return reactive(result)
        },
        set(target, key, value, receiver) {
            if (target[key] === value) {
                return true
            }
            const result = Reflect.set(target, key, value, receiver)
            console.log("更新视图")
            return result
        },
        deleteProperty(target, key) {
            const result = Reflect.deleteProperty(target, key)
            return result
        }
    }
    return new Proxy(target, proxyConfig)
}

const data = {
    name: "小明",
    source: "100",
    info: {
        city: "北京"
    }
}
const proxyData = reactive(data)

console.log(proxyData.info)

