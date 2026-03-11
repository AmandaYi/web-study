import 'package:flutter/material.dart';

// class MainPage extends StatefulWidget {
//   @override
//   State<StatefulWidget> createState() {
//     // TODO: implement createState
//     return _MainPageState();
//   }
// }

// class _MainPageState extends State<MainPage> {
class MainPage extends StatelessWidget {
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

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "滚动列表",
      home: Scaffold(
        appBar: AppBar(title: Text("滚动列表")),
        body: Stack(
          children: [
            SingleChildScrollView(
              controller: _sc,
              child: Column(children: productList()),
            ),
            Positioned(
              left: 10,
              top: 60,
              child: GestureDetector(
                onTap: () {
                  _sc.animateTo(
                    0,
                    duration: Duration(seconds: 3),
                    curve: Curves.easeIn,
                  );
                },
                child: Container(
                  width: 30,
                  height: 30,
                  child: Text("顶部"),
                  decoration: BoxDecoration(color: Colors.blue),
                ),
              ),
            ),
            Positioned(
              right: 10,
              bottom: 300,
              child: GestureDetector(
                onTap: () {
                  // _sc.jumpTo(_sc.position.maxScrollExtent);
                  _sc.animateTo(
                    _sc.position.maxScrollExtent,
                    duration: Duration(seconds: 3),
                    curve: Curves.easeIn,
                  );
                },
                child: Container(
                  width: 30,
                  height: 30,
                  child: Text("底部"),
                  decoration: BoxDecoration(color: Colors.blue),
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
