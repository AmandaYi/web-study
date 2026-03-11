void main() {
  // 和JS一样，都是单线程的,遇到阻塞就放入异步队列里面

  // 微任务队列
  // Future.microtask();
  // 事件队列
  // Future, Future.delayed(),I/O操作（文件，网络）等

  // 可以理解为Promise
  Future f = Future(() {
    print("调用了");
    return "结果的值"; // 执行成功的结果
    // throw Exception("结果的值失败了"); // 执行失败的结果
  });

  f.then((value) {
    print(value);
  });
  f.catchError((err) {
    print(err);
  });

  // 链式调用就是return的返回一个Future即可
  Future(() => 1)
      .then((v) {
        return Future(() => 2);
      })
      .then((v) {
        return Future(() => 3);
      })
      .then((v) {})
      .then((v) {})
      .then((v) {});

  // async await
  void getList() async {
    try {
      await Future(() {
        return "得到后端的列表";
      });
    } catch (e) {}
    await Future.delayed(Duration(seconds: 2)); // 这里等待2秒执行后面的逻辑
    print("得到列表了");
  }

  getList();
}
