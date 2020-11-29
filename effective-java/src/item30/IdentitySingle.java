package item30;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author: qujundong
 * @date: 2020/11/29 上午10:42
 * @description:
 */
public class IdentitySingle {
    private static UnaryOperator<Object> INDENTITY_FN = (t) -> t;
    private static List<Object> list = new ArrayList<>();
    @SuppressWarnings("unchecked")
    public static <T>UnaryOperator<T> identityFunction(){
        return (UnaryOperator<T>)INDENTITY_FN;
    }
    @SuppressWarnings("unchecked")
    public static <T> List<T> getList(){
        return (List<T>)list;
    }
    // Sample program to exercise generic singleton

    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));
        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));

    }

}
