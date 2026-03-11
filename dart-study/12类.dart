void main() {
  // Order o = Order.createOrder("联想电脑");
  // o.successPay();
  // Order o2 = Order.createOrder("联想电脑2");
  // o2.successPay();
  UserOrder uo = UserOrder();
  uo.successPay();
}

class Order {
  String orderId = "no100";
  String productName = "电脑";
  void successPay() {
    print("${this.orderId} ${this.productName}");
  }

  // 默认构造函数
  Order(String productName) {
    this.productName = productName;
    print("默认构造函数初始化");
  }
  // 自主调用的构造函数
  Order.createOrder(String productName) {
    this.productName = productName;
    print("自主调用的构造函数初始化");
  }
}

// 继承
class UserOrder extends Order {
  // UserOrder() : super("联想电脑型号book100") {}
  UserOrder() : super.createOrder("联想电脑型号book100") {} // 这样也行，只要调用一个构造函数就行了

  // 重写方法
  @override
  void successPay() {
    // TODO: implement successPay
    //
    print("用户购买了${this.productName}");
  }
}
