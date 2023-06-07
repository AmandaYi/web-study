
public class ExceptionTest {
//    编写一个类ExceptionTest，在main方法中使用try、catch、finally，要求：
//            在try块中，编写被零除的代码。
//            在catch块中，捕获被零除所产生的异常，并且打印异常信息
//在finally块中，打印一条语句。


    public static void main(String[] args) {

        try {
            int x = 1;
            int y = 1;
            int z = x / y;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage().toString());
            return ;
        } finally {
            System.out.println("异常结束");
        }

        int x = 2;
        System.out.println(x);
    }

}
