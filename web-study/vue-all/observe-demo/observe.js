// 处理observer

let data = {
    name: "1",
    age: "2",
    ccc: {}
}
observer(data)

data.name = "123"
data.ccc = {
    ddd: "111"
}
data.ccc.ddd = "999"

function updateView() {
    console.log("视图更新")
}

const oldArrayPrototype = Array.prototype;
// 创建一个空对象，但是原型指向数组的原型，不会破坏数组原型，
// 再给空对象添加对应的操作数组的方法就能完成视图之间的绑定更新
const arrObject = Object.create(oldArrayPrototype);

// 然后给arrObject添加方法即可
["push", "pop", "splice", "shift", "unshift"].forEach(methodName => {
    arrObject[methodName] = function () {
        updateView()
        oldArrayPrototype[methodName].call(this, ...arguments)
    }
})



function observer(target) {
    if (typeof target !== "object" || target === null) {
        // 直接返回即可 
        return target
    }
    if (Array.isArray(target)) {
        // 如果是数组，需要修改数组的原型为包装好的原型
        target.__proto__ = arrObject
    }
    // 重新定义各个属性，for in也可以遍历数据，因此这里用for in遍历
    for (let key in target) {
        defineReactive(target, key, target[key])
    }
}


function defineReactive(target, key, value) {
    observer(value)
    // 使用对象拦截进行监听数据
    Object.defineProperty(target, key, {
        get() {
            return value
        },
        set(newValue) {
            if (newValue !== value) {
                value = newValue
                observer(value)
                updateView()
            }
        }
    })
}

