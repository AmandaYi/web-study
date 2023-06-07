
public class FinalTest {

    private static final String TAG = "FinalTest";

    final String NAME;

    public FinalTest(String name) {
        this.NAME = name;
    }

    public void init() {
        final String NAME;
        NAME = "1";
    }


    public static void main(String[] args) {

        final Double PI = 3.14;
        System.out.println(PI);

    }
}
