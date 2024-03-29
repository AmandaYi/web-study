let name = Symbol("警察");
console.log(name) // 红字 Symbol(警察)
console.log(name.toString()) // 黑字Symbol(警察)



let skill = Symbol()
let obj ={
    name:"小明"
}
obj[skill]= "web"
console.log(obj) //{Symbol(): "web"}


for (let key in obj) {
    console.log(key) // name
}
// Promise
let list = [{
    name: "tom"
}]
function GetList(resoleve, reject) {
    let rand = Math.random()
    let timer = null
    if (rand > 0.3) {
        console.log("请求中,请稍等!")
        timer = setTimeout(() => {
            resoleve(list)
            clearTimeout(timer)
        }, 2000)
    } else {
        reject(new Error("网络异常!"))
    }

}

function ShowList(resoleve, reject) {
    let rand = Math.random()
    if (rand > 0.5) {
        resoleve(list)
    } else {
        reject(new Error("展示错误"))
    }
}

function ShowToast(resoleve, reject) {
    let rand = Math.random()
    if (rand > 0.5) {
        resoleve(list)
    } else {
        reject(new Error("弹窗识别错误"))
    }
}

new Promise(GetList)
    .then(value => {
        console.log(value)
        return new Promise(ShowList)
    })
    .catch((err) => {
        console.error(err)
    })
    .then(value => {
        console.log(value)
        return new Promise(ShowToast)
    })
    .catch((err) => {
        console.error(err)
    })
    .then(value => {
        console.log(value)
    })
    .catch((err) => {
        console.error(err)
    })
