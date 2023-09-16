// const data = {
//     name: "zhangsan",
//     source: 100
// }
const data = ["a","b","c"]

const proxyData = new Proxy(data, {
    get(target, key, receiver) {
        const result = Reflect.get(target, key, receiver)
        console.log("get key", key)
        return result
    },
    set(target, key, value, receiver) {
        const result = Reflect.set(target, key, value, receiver)
        console.log("set key", key, value)
        return result
    },
    deleteProperty(target, key) {
        const result = Reflect.deleteProperty(target, key)
        console.log("del key", key)
        return result
    }
})
proxyData.push("d")
// proxyData.name = "小张"
// console.log("proxyData.name=",proxyData.name)