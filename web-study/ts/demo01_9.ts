// 认识接口
// 定义接口的关键字是interface。我们现在就来定义一个接口，这个接口是用来规范丈夫的。

interface Husband {
    sex: string
    interest: string
}
let myhusband: Husband = { sex: '男', interest: '看书、作家务' }
// console.log(myhusband)
// 可选参数的接口
// interface SearchMan {
//     (source: string, subString: string): boolean
// }
// let mySearch: SearchMan
// mySearch = function (source: string, subString: string): boolean {
//     let flag = source.search(subString)
//     return (flag != -1)
// }
// console.log(mySearch('高、富、帅、德', '胖')) //false


interface SearchMan {
    (source: string[], subString: string): boolean
}
let mySearch = function (source: string[], subString: string): boolean {
    if (source.indexOf(subString) > -1) {
        return true
    }
    return false
}
let bool = mySearch(["高", "富", "帅"], "帅")
console.log(bool) //true