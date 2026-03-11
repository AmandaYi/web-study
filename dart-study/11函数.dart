void main() {
  print(add(1, 2));
  print(reduce(1, 2));

  print(showText("1", "2", "3"));
  print(showText1("1", "2", "3"));
}

int add(int a, int b) {
  return a + b;
}

void add2() {
  print("no return");
}

// 自动推断返回类型
reduce(int a, int b) {
  return a - b;
}

// 可选位置参数
String showText(
  String text1, [
  String? text2 = "text2",
  String? text3 = "text3",
]) {
  return text1 + text2! + text3!;
}

// 还有一种没有中括号的形式，这种并不被叫做可选位置参数，只能说是还是三个参数的函数，调用的时候只能传三个参数，如果加了中括号，那么后面的参数不强制数量
String showText1(String text1, String? text2, String? text3) {
  return text1 + text2! + text3!;
}
