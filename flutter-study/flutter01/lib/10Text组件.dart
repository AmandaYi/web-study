import 'package:flutter/material.dart';

// 无状态组件，生命周期只有一个build。在父组件更新的时候的，影响了子组件的时候，会执行子组件的build
class MainPage extends StatelessWidget {
  Text showProductName() {
    return Text("电脑");
  }

  Widget showProductDesc() {
    return Text.rich(
      TextSpan(
        children: [
          TextSpan(
            text: "电脑",
            style: TextStyle(fontSize: 15, color: Colors.redAccent),
          ),
          TextSpan(
            text: "很好用",
            style: TextStyle(fontSize: 12, color: Colors.grey),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(Object context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Column(children: [showProductName(), showProductDesc()]),
        bottomNavigationBar: Container(
          height: 100,
          child: Center(child: Text("首页")),
        ),
      ),
    );
  }
}

void main() {
  runApp(MainPage());
}
