import 'package:flutter/material.dart';

// 无状态组件，生命周期只有一个build。在父组件更新的时候的，影响了子组件的时候，会执行子组件的build
class MainPage extends StatelessWidget {
  List<Widget> orderList() {
    return List.generate(20, (index) {
      String t = "订单编号是" + index.toString();
      return Container(
        height: 50,
        width: 50,
        decoration: BoxDecoration(color: Colors.amber),
        alignment: Alignment.center,
        child: Text(t),
      );
    });
  }

  @override
  Widget build(Object context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Wrap(
          spacing: 20,
          runSpacing: 10,
          direction: Axis.horizontal, // 横向自动换行
          children: orderList(),
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
