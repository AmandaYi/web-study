// var arr = ["Tom", "Jerry", "Spike", "taike"]
// // arr[0]
// // arr[1]
// // arr[2]

// // arr[x]

// /**
//  * 
//  * 
//  * for循环三步走
//  * 1. 声明初始化值
//  * 
//  * 2. 创造终止条件, boolean
//  * 
//  * 3. 对初始化值进行改变,以至于能够打破终止条件
//  *  */

// // for (i = 0; i = i + 1; i < 3) {
// //     //    console log;("hello"+var)
// //     // console.log(arr)
// // }
// // 数组处理标准方式
// for (let i = 0; i < arr.length; i++) {
//     //    console log;("hello"+var)
//     // console.log(arr)

//     console.log("helleo " + arr[i])
// }

["Tom", "Jerry", "Spike", "taike"].sort((a, b) => { return a - b }).reverse().map(item => console.log("hello " + item))


