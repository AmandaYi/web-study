void main() {
  var age = 20; // var之后的类型，不能被改变，这里已经确定了类型了。
  age = 30;
  print(age);
  age = 1 + 1;
  print(age);
  var tmp = age.toString(); // 可以转换
  print(tmp);

  // 常量
  const pi = 3.14; // const声明 编译器的不改变的值
  print(pi);
  final now = DateTime.now(); // final声明 运行期的不改变的值
  print(now.year);
}
