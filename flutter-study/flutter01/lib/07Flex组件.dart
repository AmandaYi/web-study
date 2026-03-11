import 'package:flutter/material.dart';

// 无状态组件，生命周期只有一个build。在父组件更新的时候的，影响了子组件的时候，会执行子组件的build
class MainPage extends StatelessWidget {
  @override
  Widget build(Object context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Center(
          child: Flex(
            direction: Axis.vertical, // 水平排列
            crossAxisAlignment: CrossAxisAlignment.stretch, // 满宽
            children: [
              Container(
                height: 20,
                decoration: BoxDecoration(color: Colors.amber),
                child: Text("顶部"),
              ),
              Expanded(
                flex: 1,
                child: Container(
                  decoration: BoxDecoration(color: Colors.blue),
                  child: Text("1"),
                ),
              ), // 各占一半父组件空间
              Expanded(
                flex: 1,
                child: Container(
                  decoration: BoxDecoration(color: Colors.amber),
                  child: Text("2"),
                ),
              ),
            ],
          ),
        ),
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
