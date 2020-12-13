package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/12 下午10:08
 * @description:
 */
public class DeathLock {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (LOCK1){
                System.out.println("thead1 get LOCK1 lock");
                synchronized (LOCK2){
                    try {
                        System.out.println("thread1 get LOCK2 lock");
                        System.out.println("thread1 release LOCK1");
                        LOCK1.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("thread1 over ...");
        }).start();
        new Thread(()->{
            synchronized (LOCK1){
                try {
                    Thread.sleep(1000);
                    System.out.println("thread2 get LOCK1 lock");
                    synchronized (LOCK2){
                        System.out.println("thread2 get LOCK2 lock");
                        System.out.println("thread2 release LOCK1");
                        LOCK1.wait();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            System.out.println("thread1 over ...");
        }).start();
        System.out.println("main thread over ...");
    }
}
