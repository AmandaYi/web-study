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