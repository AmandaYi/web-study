"use strict";
// 在制作大型应用的时候，为了让程序更加有层次感和变量之间不互相干扰，
// 我们可以使用命名空间来构建程序。举个小例子：比如“德华”这件事，帅哥也有叫德华的，二师兄也有叫德华的。那我们要如何区分那。这对于女孩子选老公来说非常重要啊。
// 命名空间的使用
// 当然命名空间就是解决这个问题的，命名空间，又称内部模块，被用于组织有些具有内在联系的特性和对象。我们来看一个例子：
var shuaiGe;
(function (shuaiGe) {
    var Dehua = /** @class */ (function () {
        function Dehua() {
            this.name = '刘德华';
        }
        Dehua.prototype.talk = function () {
            console.log('我是帅哥刘德华');
        };
        return Dehua;
    }());
    shuaiGe.Dehua = Dehua;
})(shuaiGe || (shuaiGe = {}));
var bajie;
(function (bajie) {
    var Dehua = /** @class */ (function () {
        function Dehua() {
            this.name = '马德华';
        }
        Dehua.prototype.talk = function () {
            console.log('我是二师兄马德华');
        };
        return Dehua;
    }());
    bajie.Dehua = Dehua;
})(bajie || (bajie = {}));
var dehua1 = new shuaiGe.Dehua();
var dehua2 = new bajie.Dehua();
dehua1.talk();
