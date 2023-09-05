const compiler = require("vue-template-compiler")

// 插值表达式
const template = `<p>{{message}}</p>`
// with(this){return _c('p',[_v(_s(message))])

// 条件表达式
const template = `<p>{{flag ? 'YES' : 'NO'}}</p>`
// "with(this){return _c('p',[_v(_s(flag ? 'YES' : 'NO'))])}

// 属性和动态属性
const template = `<div :class="content">
    <div id="innerDiv"></div>
</div>`
// with(this){
//     return _c('div',{class:content}, [_c("div",{attrs:{"id":"innerDiv"}})])
// }

// v-if三元表达式
const template = `<div>
    <p v-if="flag == 'a'">A</p>
    <p v-else>B</p>
</div>`
// with(this){
//     return _c("div",[(flag == 'a')?_c('p',[_v("A")]):_c("p",[_v("B")])])
// }

// 循环
const template = `<ul>
    <li v-for='item in list'>{{item}}</li>
</ul>`

// with(this){
//     return _c("ul", _l((list), function(item){return _c(_v(_s(item)))}),0)
// }

// 事件
const template = `
<button @click="clickFunc">apply</button>`
// with(this) {
//     return  _c ("button", {on: {"click": clickFunc}}, [_v("apply")])
// }

const template =`<input v-model="name"/>`
// with(this){
//     return _c("input", {on:{"input":function(event){return name = event.target.value}}, attrs:{"value":name}})
// }
// with(this){return _c('input',{directives:[{name:"model",rawName:"v-model",value:(name),expression:"name"}],
// domProps:{"value":(name)},on:{"input":function($event){if($event.target.composing)return;name=$event.target.value}}})}

console.log(compiler.compile(template))