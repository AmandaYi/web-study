import 'package:flutter/material.dart';

// 无状态组件，生命周期只有一个build。在父组件更新的时候的，影响了子组件的时候，会执行子组件的build
class MainPage extends StatelessWidget {
  Image showImageAsset() {
    return Image.asset(
      "lib/images/1.gif",
      fit: BoxFit.cover,
      width: 200,
      height: 200,
    );
  }

  Image showImageNetwork() {
    return Image.network(
      "https://docs.flutter.dev/assets/images/dash/dash-fainting.gif",
      fit: BoxFit.cover,
      width: 200,
      height: 200,
    );
  }

  @override
  Widget build(Object context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Column(children: [showImageAsset(), showImageNetwork()]),
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
