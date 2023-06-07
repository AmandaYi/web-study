// 找18岁的小姐姐
// 找28岁的小姐姐
// 找38岁的小姐姐

// function serachXiaoJieJie(age: number): string {
//     return "找" + age + "岁的小姐姐"
// }
// var age: number = 18
// var xiaoman: string = serachXiaoJieJie(age)
// console.log(xiaoman)

// 可选参数
// function serachXiaoJieJie(age: number, stature?: string): string {
//     if (stature != undefined) {
//         return "找" + age + "岁," + stature + "的小姐姐"
//     } else {
//         return "找" + age + "岁的小姐姐"


//     }
// }
// var age: number = 18
// var xiaoman: string = serachXiaoJieJie(age, "水蛇腰")
// console.log(xiaoman)

// 默认参数
// function serachXiaoJieJie(age: number = 18, stature: string = "水蛇腰"): string {
//     if (stature != undefined) {
//         return "找" + age + "岁," + stature + "的小姐姐"
//     } else {
//         return "找" + age + "岁的小姐姐"
//     }
// }
// var age: number = 18
// var xiaoman: string = serachXiaoJieJie()
// console.log(xiaoman)
// 有时候我们有这样的需求，我传递给函数的参数个数不确定。例如：我找小姐姐的时候有很多要求，个人眼光比较挑剔。这时候你不能限制我，我要随心所欲。
// 默认参数
function serachXiaoJieJie(...yaoqiu: string[]): string {
    let result = ""
    for (let i = 0; i < yaoqiu.length; i++) {
        result = result + yaoqiu[i]
    }
    return "找" + result + "的小姐姐"
}
var age: number = 18
var xiaoman: string = serachXiaoJieJie("18岁", "水蛇腰", "皮肤白", "180厘米")
console.log(xiaoman)