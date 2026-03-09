void main() {
  dynamic text = 1;
  text = "你好";
  text = <String>["你好"];
  // dynamic 是动态类型，可以作为任何类型声明
  print(text.length);
  // dynamic是个危险的类型能不用就不用，
  // dynamic和var的区别是，var声明后，类型根据值的类型推导，后面就不能改变类型了，dynamic是随时改变
  // dynamic就是运行时候的，编译器就是有错误也不会报错
}
