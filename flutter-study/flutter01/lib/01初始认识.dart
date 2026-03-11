import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      title: "flutter 01",
      theme: ThemeData(),
      home: Scaffold(
        appBar: AppBar(title: Text("首页")),
        body: Container(child: Center(child: Text("内容"))),
        bottomNavigationBar: Container(
          height: 100,
          child: Center(child: Text("底部")),
        ),
      ),
    ),
  );
}
