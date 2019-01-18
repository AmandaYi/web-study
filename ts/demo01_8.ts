// 类方法的重写
// 重写就是在子类中重写父类的方法。
// 先是继承了父类的方法，然后通过super关键字调用了父类的方法，实现了技能的增加。
class Person {
    public name: string=""
    public skill() {
        console.log("区块链")
    }
}


class XiaoJieJie extends Person {
    public language: string[] = ["英语", "法语", "汉语"]
    // 这里是重写
    public skill() {
        super.skill() //先是继承了父类的方法，然后通过super关键字调用了父类的方法，实现了技能的增加。
        console.log("人工智能")
    }
}

let JieJie: XiaoJieJie = new XiaoJieJie()
JieJie.name
JieJie.skill()
JieJie.language
JieJie.skill() // 输出两行,分部是 区块链以及人工智能