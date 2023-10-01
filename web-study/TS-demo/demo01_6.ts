// let str01: String = new String("name")
// let str02: string = "name"
// console.log(str01) //[String: 'name']
// console.log(str02) //name




// 1.不传递任何参数
let date: Date = new Date()
console.log(date) // 2019-01-16T07:37:39.555Z
// 2. 传递一个整数
// 传递一个整数，这个整数代表的是距离1970-01-01 00:00:00的毫秒数
// 传入参数为1000，将创建一个表示1970-01-01 00:00:01的日期对象
let date1: Date = new Date(1000)
console.log(date1) // 1970-01-01T00:00:01.000Z
// 3.传递一个字符串
// 如果传递一个表示日期的字符串，就会生成相对应的日期对象。
// 字符串的格式常用:yyyy/MM/dd hh:mm:ss，
// yyyy-MM-dd hh:mm:ss，
// yyyy-MM-ddThh:mm:ss等,具体可以参看下面的例子。
let date2_1: Date = new Date("2019/1/16 15:41:00")
let date2_2: Date = new Date("2019-1-16 15:41:00")
let date2_3: Date = new Date("2019-01-6T15:41:00") // 如果月份,天小于10,那么月份,天必须前面补上0
console.log(date2_1) // 1970-01-01T00:00:01.000Z
console.log(date2_2) // 1970-01-01T00:00:01.000Z
console.log(date2_3) // 1970-01-01T00:00:01.000Z
// 4.传递表示年月日时分秒的变量 
// let d: Date = new Date(year, month, day, hours, minutes, seconds, ms);
// year 表示年份，4位数字。
// month表示月份，数值是0(1月)~11(12月)之间的整数。
// day 表示日期。数值是1~31之间的整数。
// hours 表示小时，数值是0-23之间的整数。
// minutes 表示分钟数，数值是0~59之间的整数。
// seconds 表示秒数，数值是0~59之间的整数。
// ms 表示毫秒数，数值是0~999之间的整数。









