// 在制作大型应用的时候，为了让程序更加有层次感和变量之间不互相干扰，
// 我们可以使用命名空间来构建程序。举个小例子：比如“德华”这件事，
// 帅哥也有叫德华的，二师兄也有叫德华的。那我们要如何区分那。 




// 命名空间的使用
// 当然命名空间就是解决这个问题的，命名空间，又称内部模块，被用于组织有些具有内在联系的特性和对象。我们来看一个例子：
namespace shuaiGe {
    export class Dehua {
        public name: string = '刘德华'
        talk() {
            console.log('我是帅哥刘德华')
        }
    }
}
namespace bajie {
    export class Dehua {
        public name: string = '马德华'
        talk() {
            console.log('我是二师兄马德华')
        }
    }
}
let dehua1: shuaiGe.Dehua = new shuaiGe.Dehua()
let dehua2: shuaiGe.Dehua = new bajie.Dehua()
dehua1.talk() //我是帅哥刘德华