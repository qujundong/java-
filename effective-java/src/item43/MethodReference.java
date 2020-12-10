package item43;

/**
 * @author: qujundong
 * @date: 2020/12/8 下午10:12
 * @description:
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class MethodReference {

    public static void main(String[] args) {
        //lambda
        strToIntFunc("1", str -> Integer.parseInt(str));
        //静态方法引用，静态方法和函数接口Function参数和返回值要一致
        strToIntFunc("1", Integer::parseInt);

        //lambda
        dateFormat(new Date(), str -> new SimpleDateFormat("yyyyMMdd").format(str));
        //实例方法引用，这种用法和静态方法引用类似，区别只是方法是实例还是静态
        dateFormat(new Date(), new SimpleDateFormat("yyyyMMdd")::format);

        //lambda
        changeStrFormat("ABC", str -> str.toLowerCase());
        //无限制的实例方法引用，注意这里，toLowerCase是实例方法，但具体的对象是作为参数传进来的
        changeStrFormat("ABC", String::toLowerCase);

        //lambda
        newIntArray(4, len -> new int[4]);
        //构造器方法引用，根据传入的参数，构造数组返回
        newIntArray(4, int[]::new);

        //lambda
        strToIntFunc("1", str -> new Integer(str));
        //构造器方法引用
        strToIntFunc("1", Integer::new);
    }

    public static int[] newIntArray(int len, Function<Integer, int[]> func) {
        return func.apply(len);
    }

    public static String changeStrFormat(String str, Function<String, String> func) {
        return func.apply(str);
    }

    public static String dateFormat(Date date, Function<Date, String> func) {
        return func.apply(date);
    }

    public static Integer strToIntFunc(String str, Function<String, Integer> func) {
        return func.apply(str);
    }

}