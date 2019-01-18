let obj = {
    name: "zzy",
    age: 18,
    sayHi: function () {
        console.log("Hello World");
    }
}
let result = obj.sayHi + ",我是" + obj.name
console.log(result)