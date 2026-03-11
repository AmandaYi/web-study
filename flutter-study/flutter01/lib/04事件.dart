import 'package:flutter/material.dart';

class MainPage extends StatelessWidget {
  @override
  Widget build(Object context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Container(
          child: Center(
            child: GestureDetector(
              child: Text("点我"),
              onTap: () {
                print("点击了我");
              },
            ),
            // child: TextButton(
            //   onPressed: () {
            //     print("点击了TextButton");
            //   },
            //   child: Text("TextButton点击了"),
            // ),
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
