import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return _MainPageState();
  }
}

class _MainPageState extends State<MainPage> {
  ScrollController _sc = ScrollController();
  List<Widget> productList() {
    return List.generate(20, (index) {
      return Container(
        height: 50,
        width: 50,
        decoration: BoxDecoration(color: Colors.amber),
        child: Text(index.toString()),
      );
    });
  }

  Widget productListWithBuilder(BuildContext ctx, int index) {
    return Container(
      height: 50,
      width: 50,
      decoration: BoxDecoration(color: Colors.amber),
      child: Text(index.toString()),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "滚动列表",
      home: Scaffold(
        appBar: AppBar(title: Text("滚动列表")),
        body: Stack(
          children: [
            // 使用GridView.count创建固定列数网格
            // GridView.count以列数为优先。指定网格多少列，Flutter 自动计算列的宽度，在空间内均匀排列
            // GridView.count(
            //   padding: EdgeInsets.all(10),
            //   crossAxisCount: 3, // 3列
            //   mainAxisSpacing: 10, // 主轴间距
            //   crossAxisSpacing: 10, // 交叉轴间距
            //   children: productList(),
            // ),
            // 使用GridView.extent指定子项最大宽度或者高度
            // GridView.extent通过maxCrossAxisExtent设置子项最大宽度/高度来计算横向或者纵向有多少列
            // GridView.extent(
            //   padding: EdgeInsets.all(10),
            //   maxCrossAxisExtent: 100, // 设置子项最大宽度/高度来计算横向或者纵向有多少列
            //   mainAxisSpacing: 10,
            //   crossAxisSpacing: 10, // 交叉轴间距
            //   children: productList(),
            // ),
            // 使用GridView.builder实现动态长网格-(懒加载，只渲染可见区域)
            // 接收gridDelegate布局委托、itemBuilder构建函数、itemCount构建数量
            // gridDelegates属性: SliverGridDelegateWithFixedCrossAxisCount / SliverGridDelegateWithMaxCrossAxisExtent
            GridView.builder(
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 3,
                mainAxisSpacing: 10,
                crossAxisSpacing: 10,
                childAspectRatio: 1,
              ),
              itemCount: 100,
              itemBuilder: productListWithBuilder,
            ),
          ],
        ),
      ),
    );
  }
}

void main() {
  runApp(MainPage());
}
