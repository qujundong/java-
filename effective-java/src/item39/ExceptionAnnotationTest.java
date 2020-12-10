package item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: qujundong
 * @date: 2020/12/6 下午2:07
 * @description:
 */
public class ExceptionAnnotationTest {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExceptionTest {
        Class<? extends Throwable> value();
    }
    public static class Sample2 {
        @ExceptionTest(ArithmeticException.class)
        public static void m1() {  // Test should pass
            int i = 0;
            i = i / i;
        }
        @ExceptionTest(ArithmeticException.class)
        public static void m2() {  // Should fail (wrong exception)
            int[] a = new int[0];
            int i = a[1];
        }
        @ExceptionTest(ArithmeticException.class)
        public static void m3() { }  // Should fail (no exception)
    }

    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;
        Class<?> clz = Sample2.class;
        Method[] me = clz.getDeclaredMethods();
        for(Method m : me){
            try {
                m.invoke(null);
                System.out.printf("Test %s failed: no exception%n", m);
            }catch (InvocationTargetException  wrappedEx){
                Throwable exc = wrappedEx.getCause();
                Class<? extends Throwable> excType =
                        m.getAnnotation(ExceptionTest.class).value();
                if (excType.isInstance(exc)) {
                    passed++;
                } else {
                    System.out.printf(
                            "Test %s failed: expected %s, got %s%n",
                            m, excType.getName(), exc);
                }
            }catch (IllegalAccessException e){
                System.out.println("Invalid @Test: " + m);
            }
        }
    }
}
