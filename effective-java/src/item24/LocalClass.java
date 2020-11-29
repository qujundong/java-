package item24;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午12:25
 * @description:
 */
public class LocalClass {
    private int a;
    public void test() {
        System.out.println("外部类...");
    }

    /**
     * 局部内部类是嵌套在方法里面的
     */

    public void testB() {
        class ClassB {
            private int b;
            public void testB() {
                System.out.println("局部类...");
            }
        }
        ClassB b = new ClassB();   //局部类创建实例
        b.testB();					//实例调用testB()方法
    }

    public static void main(String[] args) {
        LocalClass localClass = new LocalClass();
        localClass.test();
        localClass.testB();
    }
}
