import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MainPageState();
  }
}

class _MainPageState extends State<MainPage> {
  TextEditingController _userNameController = TextEditingController();
  TextEditingController _passwordController = TextEditingController();
  // 表单
  Widget showForm() {
    return Column(
      children: [
        TextField(
          controller: _userNameController,
          decoration: InputDecoration(
            contentPadding: EdgeInsets.only(left: 20),
            hintText: "用户名",
            fillColor: const Color.fromARGB(245, 245, 245, 221),
          ),
        ),
        TextField(
          controller: _passwordController,
          decoration: InputDecoration(
            contentPadding: EdgeInsets.only(left: 20),
            hintText: "密码",
            fillColor: const Color.fromARGB(245, 245, 245, 221),
          ),
        ),
      ],
    );
  }

  @override
  Widget build(Object context) {
    return MaterialApp(
      title: "状态组件标题",
      home: Scaffold(
        appBar: AppBar(title: Text("标题")),
        body: Column(children: [showForm()]),
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
