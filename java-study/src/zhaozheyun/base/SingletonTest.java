
import java.io.IOException;
import java.util.Properties;

//饿汉式：看到名称就知道一开始就把实例化给声明了
class SingletonHunger {
    //    禁止直接调用
    private static SingletonHunger singletonHunger = new SingletonHunger();

    //    使用私有构造器禁止外边初始化对象
    private SingletonHunger() {
    }

    //    使用方法返回单例
    public static SingletonHunger getInstance() {
        return singletonHunger;
    }

    public String getSystemName() {
        Properties props = System.getProperties();

        return props.getProperty("os.name");
    }
}

//懒汉式
//就是用到的时候，才想着初始化
class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        synchronized (SingletonLazy.class) {
            if (singletonLazy != null) {
                return singletonLazy;
            } else {
                singletonLazy = new SingletonLazy();
                return singletonLazy;
            }
        }
    }

    public String getSystemVersion() {
        return System.getProperty("os.version");
    }

    //    得到进程
    public String HuTollTest() {
//        return SystemUtil.getUserInfo().getTempDir();
        return null;
    }
}


public class SingletonTest {
    public static void main(String[] args) {
        SingletonHunger singletonHunger = SingletonHunger.getInstance();
        System.out.println(singletonHunger.getSystemName());

        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        System.out.println(singletonLazy.getSystemVersion());
        System.out.println(singletonLazy.HuTollTest());
//        ScriptUtil.eval("print('Script test!');");
        Runtime currentRuntime = Runtime.getRuntime(); // 饿汉式单例

    }
}
