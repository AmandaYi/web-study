import 'package:flutter/material.dart';

class MainPage extends StatelessWidget {
  // 子传父信息，使用回调函数即可
  push(String message) {
    print(message);
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "通信",
      // 父子 通信  父 -> 子
      home: Column(
        children: [Order(orderNo: "123", push: push)],
      ),
    );
  }
}

class Order extends StatelessWidget {
  final String? orderNo;
  final Function(String pushMessage) push;
  const Order({Key? key, this.orderNo, required this.push}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Row(
        children: [
          Text(orderNo!),
          GestureDetector(
            onTap: () {
              print("传递给父信息");
            },
            child: Text("传递给父信息"),
          ),
        ],
      ),
    );
  }
}

void main() {
  runApp(MainPage());
}
