import 'package:flutter/material.dart';

// 无状态组件，生命周期只有一个build。在父组件更新的时候的，影响了子组件的时候，会执行子组件的build
class MainPage extends StatelessWidget {
  Positioned PositionBox() {
    return Positioned(
      right: 100,
      bottom: 50,
      child: Container(
        height: 50,
        width: 50,
        decoration: BoxDecoration(color: Colors.blue),
      ),
    );
  }

  @override
  Widget build(Object context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Stack(
          children: [
            Center(child: Container(color: Colors.amber)),
            PositionBox(),
          ],
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
