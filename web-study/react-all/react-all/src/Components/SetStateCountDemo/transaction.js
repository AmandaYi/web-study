transaction.initialize = function () {
    console.log("initialize")
}
transaction.close = function () {
    console.log("close")
}
function method() {
    console.log(log)
}
transaction.perform(method)

transaction.perform = function (callback) {
    this.initialize()
    callback && callback() // 假如此处有宏任务队列，那么肯定setState必定同步更新
    this.close()
}