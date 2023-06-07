import java.lang.reflect.Field;

class BaseReflect {
    public String name = "";
}

public class ReflectTestBase {
    public static void main(String[] args) {
        new ReflectTestBase().useSetBaseReflectName();
    }

    public void useSetBaseReflectName() {
        String str = "com.zhaozheyun.base.BaseReflect";
        try {
            Class clazz = Class.forName(str);
            Object obj = clazz.newInstance();

//            这里的name需要public修饰符
            Field field = clazz.getField("name");
            field.set(obj, "xxx");

            System.out.println(field.get(obj));

        } catch (ClassNotFoundException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
