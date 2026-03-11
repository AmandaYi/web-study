import 'package:dio/dio.dart';
import 'package:flutter/material.dart';

// 获取网络数据，需要在有状态组件中获取使用
class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _MainPageState();
  }
}

class _MainPageState extends State<MainPage> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "路由",
      // 1. 基础路由
      // home: Container(
      //   child: Column(
      //     children: [
      //       // 这是一种简单跳转路由的方式
      //       GestureDetector(
      //         onTap: () {
      //           Navigator.push(
      //             context,
      //             // 点击后使用MaterialPageRoute 增加一个路由，并跳转
      //             MaterialPageRoute(
      //               builder: (ctx) {
      //                 return ProductDetail();
      //               },
      //             ),
      //           );
      //         },
      //         child: Text("跳转到商品详情"),
      //       ),
      //     ],
      //   ),
      // ),
      // 2. 多页面路由配置，完整项目用的方案
      initialRoute: "/productDetail",
      routes: {
        "/productDetail": (ctx) => ProductDetail(),
        "/userInfo": (ctx) => UserInfo(),
      },
      home: Column(
        children: [
          TextButton(
            onPressed: () {
              Navigator.pushNamed(context, "/productDetail");
            },
            child: Text("商品详情"),
          ),
          TextButton(
            onPressed: () {
              Navigator.pushNamed(context, "/userInfo");
            },
            child: Text("用户详情"),
          ),
        ],
      ),
    );
  }
}

class ProductDetail extends StatelessWidget {
  const ProductDetail({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text("商品详情页面"),
        TextButton(
          onPressed: () {
            Navigator.pop(context);
          },
          child: Text("返回上一层"),
        ),
      ],
    );
  }
}

class UserInfo extends StatelessWidget {
  const UserInfo({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text("用户中心页面"),
        TextButton(
          onPressed: () {
            Navigator.pop(context);
          },
          child: Text("返回上一层"),
        ),
      ],
    );
  }
}

void main() {
  runApp(MainPage());
}
