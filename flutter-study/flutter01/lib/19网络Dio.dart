import 'package:dio/dio.dart';
import 'package:flutter/material.dart';

// 获取网络数据，需要在有状态组件中获取使用
class MainPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return _MainPageState();
  }
}

class _MainPageState extends State<MainPage> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: "网络", home: Text("网络"));
  }

  // 获取网络数据
  initData() {
    Dio()
        .get("http://")
        .then((v) {
          print(v);
        })
        .catchError((err) {});
  }

  // 不要在这里获取网络数据，他可能会陷入循环
  void didChangeDependencies() {
    // this.initData();
  }

  // 最佳是在这个initState周期，获取数据，这个周期只会执行一次。
  @override
  void initState() {
    this.initData();
  }
}

void main() {
  runApp(MainPage());
}
