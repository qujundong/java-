package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/13 下午3:46
 * @description:
 */
public class IsInterruptedAndInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (; ; ) {

            }
        });
        thread1.start();
        thread1.interrupt();
        System.out.println("isInterrupted: " + thread1.isInterrupted());
        System.out.println("isInterrupted: " + thread1.interrupted());
        System.out.println("isInterrupted: " + Thread.interrupted());
        System.out.println("isInterrupted: " + thread1.isInterrupted());
        thread1.join();
        System.out.println("main thread is over");
    }
}
