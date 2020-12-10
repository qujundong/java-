package item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: qujundong
 * @date: 2020/12/6 下午2:00
 * @description:
 */
public class AnnotationTest {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {
    }
    public static class Sample {
        @Test public static void m1() { }  // Test should pass
        public static void m2() { }
        @Test public static void m3() {     // Test should fail
            throw new RuntimeException("Boom");
        }
        public static void m4() { }
        @Test public void m5() { } // INVALID USE: nonstatic method
        public static void m6() { }
        @Test public static void m7() {    // Test should fail
            throw new RuntimeException("Crash");
        }
        public static void m8() { }
    }
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Sample.class;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
