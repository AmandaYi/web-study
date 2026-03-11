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
          child: Row(
            children: [
              // Container(
              //   margin: EdgeInsets.only(left: 50),
              //   height: 200,
              //   width: 200,
              //   // alignment: Alignment.topCenter, // 子组件对齐
              //   alignment: Alignment.center, // 子组件对齐
              //   transform: Matrix4.rotationZ(0.1),
              //   decoration: BoxDecoration(
              //     border: Border.all(color: Colors.blue),
              //     borderRadius: BorderRadius.all(Radius.circular(10.5)),
              //     boxShadow: [
              //       BoxShadow(color: Colors.amberAccent, offset: Offset(5, 5)),
              //     ],
              //   ),
              //   child: Text(
              //     "中心",
              //     style: TextStyle(color: Color.fromRGBO(255, 100, 0, 1)),
              //   ),
              // // ),
              // Align(
              //   widthFactor: 2,
              //   heightFactor: 2,
              //   child: Icon(Icons.abc, size: 100, color: Colors.green),
              // ),
              Container(
                margin: EdgeInsets.only(left: 20),
                height: 200,
                width: 200,
                decoration: BoxDecoration(color: Colors.black),
                child: Padding(
                  padding: EdgeInsets.all(10),
                  child: Container(
                    decoration: BoxDecoration(color: Colors.amber),
                  ),
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
