"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// 类方法的重写
// 重写就是在子类中重写父类的方法。
// 先是继承了父类的方法，然后通过super关键字调用了父类的方法，实现了技能的增加。
var Person = /** @class */ (function () {
    function Person() {
        this.name = "";
    }
    Person.prototype.skill = function () {
        console.log("区块链");
    };
    return Person;
}());
var XiaoJieJie = /** @class */ (function (_super) {
    __extends(XiaoJieJie, _super);
    function XiaoJieJie() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.language = ["英语", "法语", "汉语"];
        return _this;
    }
    // 这里是重写
    XiaoJieJie.prototype.skill = function () {
        _super.prototype.skill.call(this); //先是继承了父类的方法，然后通过super关键字调用了父类的方法，实现了技能的增加。
        console.log("人工智能");
    };
    return XiaoJieJie;
}(Person));
var JieJie = new XiaoJieJie();
JieJie.name;
JieJie.skill();
JieJie.language;
JieJie.skill(); // 输出两行,分部是 区块链以及人工智能
