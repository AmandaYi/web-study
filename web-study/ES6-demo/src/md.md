## 对象赋值
ES6允许把声明的变量直接赋值给对象，我们看下面的例子。
```javascript
let name="jspang";
let skill= 'web';
var obj= {name,skill};
console.log(obj);  //Object {name: "jspang", skill: "web"}
```
## 对象Key值构建
有时候我们会在后台取出key值，而不是我们前台定义好的，这时候我们如何构建我们的key值那。比如我们在后台取了一个key值，然后可以用[ ] 的形式，进行对象的构建。
```javascript
let name = "无尽光芒!"
let key = "skill"
let obj = {
    [key]: "web",
    add: function () { },
    reduce() { },
    sum: () => { }
}
```
## 自定义对象方法
```javascript
let obj2 = {
    [key]: "web",
    add: function () { },
    reduce() { },
    sum: () => { }
}
```
## Object.is() 对象比较
===为同值相等，is()为严格相等
```javascript
console.log(Object.is(NaN, NaN)) // true
console.log(Object.is(+0, -0)) // false
console.log(Object.is(obj.skill, obj2.skill)) // true
console.log(Object.is(obj.add, obj2.add)) // false
```
## Object.assign()合并对象
```javascript
let obj3 = {
    name: "study"
}
console.log(Object.assign(obj, obj2, obj3))
```