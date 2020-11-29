package item24;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午12:08
 * @description:
 */
public class InnerClass {
    public static class StaticInner{

    }
    public class NonStaticInner{

    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();
        NonStaticInner nonStaticInner = new InnerClass().new NonStaticInner();
    }
}
