import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

    public static void main(String[] args) {
//        List list = new ArrayList();
//
//        Integer i = 10000;
//        Integer i2 = 10000;
//        list.add(i2);
//        System.out.println(i.equals(i2));
//        System.out.println(list.contains(i));
//
////        retainAll 求交集
//        List list2 = new ArrayList();
//        list2.add(1);
//        list2.add(2);
//        List list3 = new ArrayList();
//        list3.add(1);
//        System.out.println(list2.retainAll(list3));
//
//        List list5 = new ArrayList();
//        list5.add(1);

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);// 1 2
    }
    private static void updateList(List list) {
        list.remove(2); // 去掉索引为2的元素
    }
}
