void main() {
  var name = "小明";
  if (name == "小明") {
    print("我是小明");
  } else if (name == "小米") {
    print("我是小米");
  } else {
    print("我是？");
  }

  print(name == "小明" ? "小明" : "我是？");

  switch (name) {
    case "小明":
      {
        print("小明");
        break;
      }
    case "小米":
      {
        print("小米");
        break;
      }
    default:
      {
        print("我是？");
      }
  }

  int i = 0;
  while (i < 10) {
    i++;
    print(i);
  }
  // 这里也有块级作用域
  for (int i = 0; i < 10; i++) {
    print(i);
  }
}
