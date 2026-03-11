import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  State<MainPage> createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  int count = 0;
  void add() {
    int t = this.count + 1;
    setState(() {
      this.count = t;
    });
  }

  void reduce() {
    int t = this.count - 1;
    setState(() {
      this.count = t;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "无状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Container(
          child: Center(
            child: Row(
              children: [
                TextButton(onPressed: add, child: Text("增加")),
                Text(count.toString()),
                TextButton(onPressed: reduce, child: Text("减去")),
              ],
            ),
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
