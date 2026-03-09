void main() {
  List payWay = ["支付宝", "微信"];
  payWay.add("云闪付"); // 尾部增加一个
  payWay.addAll(["好多支付方式"]); //尾部增加一个列表
  payWay.remove("云闪付"); // 移除内容等于云闪付的这个
  payWay.forEach((item) {
    print(item);
  }); // 循环
  // 还有很多方法，查看API
}
