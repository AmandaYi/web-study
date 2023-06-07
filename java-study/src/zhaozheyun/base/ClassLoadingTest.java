

class Father100 {
    static String name   = "1";
    static {
        System.out.println("Father100正在初始化");
    }
}
//class Son100 extends Father {
//    static {
//        System.out.println("Son100正在初始化");
//    }
//    static String name   = "2";
//    final static String NAME   = "2";
//}






public class ClassLoadingTest {
    public static void main(String[] args) {

//        Son100[] son100s = new Son100[5];

//       System.out.println(Father100.name); // 静态属性是调用哪个类，哪个类初始化，不会影响到互相继承的类
//       System.out.println(Son100.name); //
//        System.out.println(Son100.NAME); //
        System.out.println("main初始化");

    }
}