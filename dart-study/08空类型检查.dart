void main() {
  String? username = null; // 声明一个可空类型
  username?.startsWith("小明"); // 对象为null的时候跳过操作，返回null
  // 假如其他地方赋值了
  // username = "小明";
  // username!.startsWith("小明"); // 程序员主观认为就是有值，告诉编译器不要报错了。

  // 安全访问的?和非空断言!的区分是，?是客观判断，!是主观判断

  String result = username ?? "默认值zero"; // 空合并

  print(result);
}
