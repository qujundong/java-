package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/13 下午4:36
 * @description:
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
//        new Thread(()->{
//            threadLocal.set("thread1");
//            System.out.println(threadLocal.get());
//        }).start();
        threadLocal.set("main thread");
        new Thread(()->{
//            threadLocal.set("thread2");
            System.out.println(threadLocal.get());
        }).start();
    }
}
