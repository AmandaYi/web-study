// const data = {
//     name: "小明",
//     source: "100"
// }
const data = ["a","b","c"]
const proxyData = new Proxy(data, {
    get(target, key, receiver) {
        const result = Reflect.get(target, key, receiver)
        const ownKeys = Reflect.ownKeys(target)
        if (ownKeys.includes(key)){
            console.log("get", key, "result:", result)
        }
        return result
    },
    set(target, key, value, receiver) {
        // 重复的数据不进行处理
        if (target[key] == value){
            return true
        }
        const result = Reflect.set(target, key, value, receiver)
        
        console.log("set", key, "value:", value)
        return result
    },
    deleteProperty(target, key) {
        const result = Reflect.deleteProperty(target, key)
        console.log("del", key, result)
        return result
    }
})
// proxyData.name = "小张2"
// proxyData.info = {
//     "city":"河南"
// }
proxyData.push("d")