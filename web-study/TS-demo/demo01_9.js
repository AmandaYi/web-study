"use strict";
// 认识接口
// 定义接口的关键字是interface。我们现在就来定义一个接口，这个接口是用来规范丈夫的。
var myhusband = { sex: '男', interest: '看书、作家务' };
var mySearch = function (source, subString) {
    if (source.indexOf(subString) > -1) {
        return true;
    }
    return false;
};
var bool = mySearch(["高", "富", "帅"], "帅");
console.log(bool); //true
