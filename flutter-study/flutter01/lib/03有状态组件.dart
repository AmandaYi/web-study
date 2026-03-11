import 'package:flutter/material.dart';

// 接受和定义参数，核心作用的是创建state对象

// 生命周期是： createState -> State对象创建 -> initState -> didChangeDependencies -> build
// 更新: didUpdateWidget(有配置变更就执行，没有不执行) -> build（只要更新就执行）
// 销毁：
class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  State<MainPage> createState() => _MainPageState();
  @override
  void initState() {
    print("initState");
  }

  @override
  void didChangeDependencies() {
    print("依赖已完成改变");
  }

  @override
  void didUpdateWidget(MainPage oldWidget) {}

  @override
  void dispose() {
    print("state全部移除");
  }
}

//  实现业务和可变数据
class _MainPageState extends State<MainPage> {
  @override
  void deactivate() {
    // TODO: implement deactivate
    print("deactivate");
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Container(child: Center(child: Text("中心"))),
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
