package chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReflectArrayCopy {
    public static Object goodCopy(Object obj, int newLength){
        Class<?> cls = obj.getClass();
        Class<?> componentType = cls.getComponentType();
        int length = Array.getLength(obj);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(obj, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[])goodCopy(a, 5);
        System.out.println(Arrays.toString(a));

        String[] b = {"abc", "ddd", "fff"};
        b = (String[])goodCopy(b, 6);
        System.out.println(Arrays.toString(b));
    }
}
