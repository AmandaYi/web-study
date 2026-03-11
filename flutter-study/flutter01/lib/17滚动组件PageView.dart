import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return _MainPageState();
  }
}

class _MainPageState extends State<MainPage> {
  PageController _pc = PageController();
  // PageView绑定controller属性，对象类型为PageController
  // controller.jumpPage/animateToPage
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
        body: CustomScrollView(
          slivers: [
            SliverToBoxAdapter(
              child: Container(
                height: 200,
                child: PageView.builder(
                  // 创建了轮播图，如果手动跳转的话，那么需要拿着_pc进行跳转即可
                  controller: _pc,
                  itemCount: 10,
                  itemBuilder: (ctx, index) => Container(
                    height: 50,
                    width: 50,
                    decoration: BoxDecoration(color: Colors.amber),
                    child: Text(index.toString()),
                  ),
                ),
              ),
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
