void main() {
  // 泛型List
  List<int> price = [1, 2, 3, 4, 5];

  // 函数泛型
  void printList<T>(List<T> list) {
    list.forEach((item) {
      print(item);
    });
  }

  Order o = Order<String>();
  print(o.productName);
}

// 类的泛型
class Order<T> {
  T? productName;
}
