import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
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
        body: CustomScrollView(
          slivers: [
            SliverToBoxAdapter(
              child: Container(
                height: 50,
                width: 50,
                decoration: BoxDecoration(color: Colors.red),
                child: Text("轮播图"),
              ),
            ),
            SliverPersistentHeader(
              pinned: true,
              delegate: _StickyCategoryDelegate(),
            ),
            SliverList.separated(
              itemBuilder: productListWithBuilder,
              separatorBuilder: (ctx, index) {
                return Container(
                  height: 20,
                  decoration: BoxDecoration(color: Colors.blue),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}

// 悬浮分类
class _StickyCategoryDelegate extends SliverPersistentHeaderDelegate {
  @override
  Widget build(
    BuildContext context,
    double shrinkOffset,
    bool overlapsContent,
  ) {
    return Container(
      color: Colors.white,
      child: ListView.builder(
        itemBuilder: (ctx, index) {
          return Container(
            width: 100,
            alignment: Alignment.center,
            decoration: BoxDecoration(color: Colors.green),
            child: Text(index.toString()),
          );
        },
      ),
    );
  }

  @override
  // TODO: implement maxExtent
  double get maxExtent => 80;

  @override
  // TODO: implement minExtent
  double get minExtent => 50;

  @override
  bool shouldRebuild(covariant SliverPersistentHeaderDelegate oldDelegate) {
    return true;
  }
}

void main() {
  runApp(MainPage());
}
