package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/12 下午10:26
 * @description:
 */
public class WaitNotifyInterupt {
    private static final Object LOCK = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                synchronized (LOCK) {
                    System.out.println("thread1 LOCK get ...");
                    synchronized (LOCK2){
                        System.out.println("thread1 LOCK2 get ...");
                        System.out.println("thread1 LOCK2 block ...");
                        LOCK2.wait();
                    }

                    System.out.println("thread1 LOCK block  ...");
                    LOCK.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread.sleep(1000);
        System.out.println("begin interrupt thread1 ...");
        thread1.interrupt();
        System.out.println("end interrupt thread1 ...");

    }
}
