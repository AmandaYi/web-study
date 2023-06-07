class ObjectStaticArea{
    // 创建本次数
    public static Integer createTotalCount = 0;
    ObjectStaticArea(){
        createTotalCount ++;
    }
}






public class ObjectStaticAreaTest {

    public void testStatic(){
        for(int i = 0; i < 3; i++) {
            new ObjectStaticArea();
        }
        System.out.println(ObjectStaticArea.createTotalCount); // 结果是3，代表该对象调用了3次
    }
}
