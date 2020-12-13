package chapter1;

/**
 * @author: qujundong
 * @date: 2020/12/12 下午10:08
 * @description:
 */
public class DeathLock2 {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (LOCK1){
                System.out.println("thead1 get LOCK1 lock ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 wait lock2...");
                synchronized (LOCK2){
                        System.out.println("thread1 get LOCK2 lock ...");
                }
            }
            System.out.println("thread1 over ...");
        }).start();
        new Thread(()->{
            synchronized (LOCK2){
                try {
                    Thread.sleep(1000);
                    System.out.println("thread2 get LOCK2 lock ...");
                    System.out.println("thread1 wait lock1...");
                    synchronized (LOCK1){
                        System.out.println("thread2 get LOCK1 lock ...");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            System.out.println("thread1 over ...");
        }).start();

    }
}
