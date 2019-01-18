// 前端对用户输入的信息进行验证，比如手机号，年龄，三围（我又要开始污了）。用于验证最好最强大的手段目前为止就是正则表达式。TypeScript的RegExp类表示正则表达式。这节我们就学习一下TypeScript里的正则表达式吧。
// 正则表达式也提供了两种方法，一种是才采用new 关键字，另一种是采用字面量的方式。
// 1. 构造函数法,
// 构造函数中可以传一个参数，也可以传递两个参数。
// 一个是字符串描述，另一个是修饰符，
// 比如g是全局修饰符，i是忽略大小写，m是多行模式。
let reg1_1: RegExp = new RegExp("zzy")
let reg1_2: RegExp = new RegExp("zzy", "igm")
let r1_1: boolean = reg1_1.test("my name is zzy")
let r1_2: boolean = reg1_2.test("my name is zzy")
// console.log(r1_1)

// 2.字面量法
// let reg2_1: RegExp = /zzy/
// let reg2_2: RegExp = /zzy/img
// RegExp中的常用方法
// RegExp对象包含两个常用方法：test( )和exec( ),功能基本相似，用于测试字符串匹配。

// test(string) ：在字符串中查找是否存在指定的正则表达式并返回布尔值，如果存在则返回 true，不存在则返回 false。
// exec(string) : 用于在字符串中查找指定正则表达式，如果 exec() 方法执行成功，则返回包含该查找字符串的相关信息数组。如果执行失败，则返回 null。
// let reg3_2 :RegExp = /zzy/
// let s3_2 :string = "my name is zzy"
// let r3_2 =reg3_2.exec(s3_2) 
// console.log(r3_2) //[ 'zzy', index: 11, input: 'my name is zzy' ]
// let reg1: RegExp = /jspang/i
// let website: string = 'jspang.com'
// console.log(reg1.exec(website))
// //[ 'jspang', index: 0, input: 'jspang.com' ]