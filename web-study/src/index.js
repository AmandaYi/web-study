


// 对象的函数解构

// 我们在前后端分离时，后端经常返回来JSON格式的数据，前端的美好愿望是直接把这个JSON格式数据当作参数，传递到函数内部进行处理。ES6就为我们提供了这样的解构赋值。

// let json = {
//     a:'jspang',
//     b:'技术胖'
// }
// function fun({a,b='jspang'}){
//     console.log(a,b);
// }
// fun(json);
// 是不是感觉方便了很多，我们再也不用一个个传递参数了。

// 数组的函数解构

// 函数能解构JSON，那解构我们的数组就更不在话下了，我们看下边的代码。我们声明一个数组，然后写一个方法，最后用…进行解构赋值。

// let arr = ['jspang','技术胖','免费教程'];
// function fun(a,b,c){
//     console.log(a,b,c);
// }
// fun(...arr);
// 这种方法其实在前面的课程中已经学过了，这里我们就当复习了。

// 



// in是用来判断对象或者数组中是否存在某个值的。我们先来看一下用in如何判断对象里是否有某个值。

// 对象判断

// let obj={
//     a:'jspang',
//     b:'技术胖'
// }
// console.log('a' in obj);  //true
// 数组判断

// 先来看一下ES5判断的弊端，以前会使用length属性进行判断，为0表示没有数组元素。但是这并不准确，或者说真实开发中有弊端。

// let arr=[,,,,,];
// console.log(arr.length); //5
// 上边的代码输出了5，但是数组中其实全是空值，这就是一个坑啊。那用ES6的in就可以解决这个问题。

// let arr=[,,,,,];
// console.log(0 in arr); //false
// let arr1=['jspang','技术胖'];
// console.log(0 in arr1);  // true
// 注意：这里的0指的是数组下标位置是否为空。
let arr = [, , , , , , , , , , ,]
console.log(0 in arr)
let count = 0
for (let [index, item] of arr.entries()) {
    if ((index in arr) == false) {
        count++
    }
}
if (count == arr.length) {
    console.log("该数组是个无效的数组!")
}
// 数组的遍历方法
// let list = [2, 4, 6, 1, 3, undefined, 5]
// list.forEach((item, index) => {
//     return item
// })
// console.log(list)
// 1.forEach

// let arr=['jspang','技术胖','前端教程'];
// arr.forEach((val,index)=>console.log(index,val));
// 

// 2.filter

// let arr=['jspang','技术胖','前端教程'];
// arr.filter(x=>console.log(x));
// 这种方法在Vue实战里我讲过，他其实也有循环的功能，这里我们在复习一遍。

// 3.some

// let arr=['jspang','技术胖','前端教程'];
// arr.some(x=>console.log(x));
// 4.map

// let arr=['jspang','技术胖','前端教程'];
// console.log(arr.map(x=>'web'));
// map在这里起到一个替换的作用，这个我们后续课程会详细讲解。

// 数组转换字符串 在开发中我们经常会碰到把数组输出成字符串的形式，我们今天学两种方法，你要注意两种方法的区别。

// join()方法

// let arr=['jspang','技术胖','前端教程'];
// console.log(arr.join('|'));
// join()方法就是在数组元素中间，加了一些间隔，开发中很有用处。

// toString()方法

// let arr=['jspang','技术胖','前端教程'];
// console.log(arr.toString());
// 转换时只是是用逗号隔开了。
let list = ["苹果","香蕉"]
console.log(list.toString())
console.log(list.toLocaleString())
console.log(list.join("-"))
